package com.example.smarttransport.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.smarttransport.base.BaseViewModel
import com.example.smarttransport.data.User
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.firestore.FirebaseFirestore
import com.example.smarttransport.user.data.models.UserDataModel
import com.example.smarttransport.user.data.remote.networkHandling.Resource
import com.example.smarttransport.user.data.reporsitory.MainRepository
import com.example.smarttransport.utils.AppManger

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.lang.Throwable
import kotlin.text.isNullOrBlank

class AuthViewModel constructor(
    override var mainRepository: MainRepository,
    override val appManger: AppManger
) : BaseViewModel(mainRepository, appManger) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    // 🟢 LiveData للـ UI
    val loginResponse = MutableLiveData<FirebaseUser?>()
    val registrationResponse = MutableLiveData<FirebaseUser?>()
    val errorMessage = MutableLiveData<String?>()

    // 🟢 بيانات المستخدم
    val emailLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()

    // 🟢 logout success
    private val _logoutSuccess = MutableStateFlow<Boolean?>(null)
    val logoutSuccess = _logoutSuccess.asStateFlow()

    // 🟢 تسجيل الدخول
    fun loginUser() {
        val email = emailLiveData.value
        val password = passwordLiveData.value

        if (email.isNullOrBlank() || password.isNullOrBlank()) {
            errorMessage.value = "Missing Required Fields!"
            return
        }

        if (password.length < 6) {
            errorMessage.value = "Password must be at least 6 characters!"
            return
        }

        loading.value = true
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null && user.isEmailVerified) {
                        loginResponse.value = user
                    } else {
                        errorMessage.value = "Please verify your email!"
                        auth.signOut()
                    }
                } else {
                    errorMessage.value = task.exception?.localizedMessage ?: "Login failed!"
                }
            }
    }

    // 🟢 تسجيل مستخدم جديد
    fun registerUser() {
        val email = emailLiveData.value
        val password = passwordLiveData.value
        val fName = firstName.value
        val lName = lastName.value

        if (email.isNullOrBlank() || password.isNullOrBlank() || fName.isNullOrBlank() || lName.isNullOrBlank()) {
            errorMessage.value = "Missing Required Fields!"
            return
        }

        if (password.length < 6) {
            errorMessage.value = "Password must be at least 6 characters!"
            return
        }

        loading.value = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                if (task.isSuccessful) {
                    val firebaseUser = auth.currentUser
                    firebaseUser?.sendEmailVerification()

                    val uid = firebaseUser?.uid ?: return@addOnCompleteListener
                    val user = User(
                        uid = uid,
                        firstName = fName,
                        lastName = lName,
                        email = email
                    )

                    firestore.collection("user")
                        .document(uid)
                        .set(user)
                        .addOnSuccessListener {
                            registrationResponse.value = firebaseUser
                        }
                        .addOnFailureListener { e ->
                            errorMessage.value = "Failed to save user: ${e.message}"
                        }
                } else {
                    errorMessage.value = task.exception?.localizedMessage ?: "Registration failed!"
                }
            }
    }

    // 🟢 تسجيل الخروج
    fun logoutUser() {
        FirebaseAuth.getInstance().signOut()
        _logoutSuccess.value = true
    }
}






