package com.example.smarttransport.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.smarttransport.ui.viewmodel.AuthViewModel
import com.example.smarttransport.base.BaseActivity
import com.homecookapp.user.databinding.ActivityLoginBinding
import com.homecookapp.user.R
import kotlin.reflect.KClass

class LoginActivity : BaseActivity<ActivityLoginBinding, AuthViewModel>() {
    override fun resourceId(): Int = R.layout.activity_login
    override fun viewModelClass(): KClass<AuthViewModel> = AuthViewModel::class

    override fun setUI(savedInstanceState: Bundle?) {
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = this
        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
    }

    override fun observer() {
        viewModel.loginResponse.observe(this) {
            Toast.makeText(this, "Welcome back ${it?.email}", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun clicks() {
        dataBinding.tvDntHaveAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        dataBinding.btnLogin.setOnClickListener {
            viewModel.loginUser()
        }
    }

    override fun callApis() {

    }
}
