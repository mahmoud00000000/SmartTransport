package com.example.smarttransport.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.smarttransport.base.BaseViewModel
import com.example.smarttransport.user.data.reporsitory.MainRepository
import com.example.smarttransport.utils.AppManger
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(
    override var mainRepository: MainRepository,
    override val appManger: AppManger,
    private val auth: FirebaseAuth
) : BaseViewModel(mainRepository, appManger) {

    fun decideNextScreen(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            delay(2000) // 2 ثواني
            val isLoggedIn = auth.currentUser != null
            onResult(isLoggedIn)
        }
    }
}