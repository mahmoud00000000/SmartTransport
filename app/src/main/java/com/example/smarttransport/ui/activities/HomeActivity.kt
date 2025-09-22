package com.example.smarttransport.ui.activities

import android.os.Bundle
import com.example.smarttransport.base.BaseActivity
import com.example.smarttransport.ui.viewmodel.AuthViewModel
import com.homecookapp.user.R
import com.homecookapp.user.databinding.ActivityHomeBinding
import com.homecookapp.user.databinding.ActivitySplashBinding
import kotlin.reflect.KClass

class HomeActivity : BaseActivity<ActivityHomeBinding, AuthViewModel>() {
    override fun resourceId(): Int = R.layout.activity_home



    override fun viewModelClass(): KClass<AuthViewModel> = AuthViewModel::class



    override fun setUI(savedInstanceState: Bundle?) {
        dataBinding.viewModel = viewModel
    }

    override fun observer() {

    }

    override fun clicks() {

    }

    override fun callApis() {

    }
}