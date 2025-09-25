package com.example.smarttransport.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.smarttransport.base.BaseActivity
import com.example.smarttransport.ui.viewmodel.AuthViewModel
import com.homecookapp.user.databinding.ActivityLoginRegisterBinding
import com.homecookapp.user.R
import kotlin.reflect.KClass

class LoginRegisterActivity : BaseActivity<ActivityLoginRegisterBinding, AuthViewModel>() {
    override fun resourceId(): Int = R.layout.activity_login_register



    override fun viewModelClass(): KClass<AuthViewModel> = AuthViewModel::class



    override fun setUI(savedInstanceState: Bundle?) {
        dataBinding.viewModel = viewModel
        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
    }

    override fun observer() {

    }

    override fun clicks() {

        dataBinding.loginBtn.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))

        }

        dataBinding.registerBtn.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))

        }

    }

    override fun callApis() {

    }

}