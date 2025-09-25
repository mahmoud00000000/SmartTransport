package com.example.smarttransport.ui

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.smarttransport.base.BaseActivity
import com.example.smarttransport.ui.activities.HomeActivity
import com.example.smarttransport.ui.activities.LoginActivity
import com.example.smarttransport.ui.activities.LoginRegisterActivity
//import com.example.smarttransport.ui.activities.LoginActivity
import com.example.smarttransport.ui.viewmodel.AuthViewModel
import com.example.smarttransport.ui.viewmodel.SplashViewModel
import com.example.smarttransport.utils.openActivity
import com.homecookapp.user.databinding.ActivitySplashBinding
import com.homecookapp.user.R
import kotlin.reflect.KClass

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override fun resourceId(): Int = R.layout.activity_splash
    override fun viewModelClass() = SplashViewModel::class

    override fun setUI(savedInstanceState: Bundle?) {
        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        viewModel.decideNextScreen { isLoggedIn ->
            if (isLoggedIn) {
                openActivity(HomeActivity::class.java)
            } else {
              openActivity(LoginRegisterActivity::class.java)
            }
            finish()
        }
    }

    override fun observer() {}
    override fun clicks() {}
    override fun callApis() {}
}