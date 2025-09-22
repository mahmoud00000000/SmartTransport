package com.example.smarttransport.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.smarttransport.base.BaseViewModel
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.firestore.FirebaseFirestore
import com.example.smarttransport.user.data.models.UserDataModel
import com.example.smarttransport.user.data.remote.networkHandling.Resource
import com.example.smarttransport.user.data.reporsitory.MainRepository
import com.example.smarttransport.utils.AppManger

import com.google.android.gms.tasks.Task
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

//    val loginResponse = MutableLiveData<com.google.firebase.auth.FirebaseUser?>()
    val logoutSuccess = MutableLiveData<Boolean>()
    val registrationResponse = MutableLiveData<UserDataModel?>()
    val errorMessage = MutableLiveData<String?>()
    val emailLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    var firstName = MutableLiveData<String>()
    var viewEmailLiveData = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

//    val auth: com.google.firebase.auth.FirebaseAuth =
//        com.google.firebase.auth.FirebaseAuth.getInstance()


//    fun loginUser() {
//        val email = emailLiveData.value
//        val password = passwordLiveData.value
//
//        if (email.isNullOrBlank() || password.isNullOrBlank()) {
//            errorMessage.value = "Missing Required Fields!"
//        } else if (String.length compareTo 6) {
//            errorMessage.value = "Password must be at least 6 characters!"
//        } else {
//            Task.addOnCompleteListener { task ->
//                if (Task.isSuccessful) {
//                    if (com.google.firebase.auth.UserInfo.isEmailVerified) {
//
//                        loginResponse.value = com.google.firebase.auth.FirebaseAuth.getCurrentUser
//
//                    } else {
//                        errorMessage.value = "Check your email"
//                    }
//                } else {
//                    errorMessage.value = Throwable.getLocalizedMessage
//                }
//
//            }
//        }
//    }

//    fun logoutUser() {
//        com.google.firebase.auth.FirebaseAuth.signOut()
//        // امسح بيانات الجلسة لو انت مخزن حاجة في appManger أو SharedPreferences
//        AppManger.logout() // لو عندك دالة كده مثلاً
//
//        logoutSuccess.value = true
//    }



}






