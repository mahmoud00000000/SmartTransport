package com.example.smarttransport.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.smarttransport.ui.viewmodel.AuthViewModel
import com.example.smarttransport.base.BaseActivity
import com.example.smarttransport.data.User
import com.homecookapp.user.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.homecookapp.user.databinding.ActivityRegisterBinding
import kotlin.reflect.KClass

class RegisterActivity : BaseActivity<ActivityRegisterBinding, AuthViewModel>() {
    override fun resourceId(): Int = R.layout.activity_register
    override fun viewModelClass(): KClass<AuthViewModel> = AuthViewModel::class

    override fun setUI(savedInstanceState: Bundle?) {
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
    }

    override fun observer() {
        viewModel.registrationResponse.observe(this) {
            Toast.makeText(this, "Registered Successfully! Check your email.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun clicks() {
        dataBinding.DoYouHaveAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        dataBinding.btnRegister.setOnClickListener {
            viewModel.registerUser()
        }
    }

    override fun callApis() {}
}
