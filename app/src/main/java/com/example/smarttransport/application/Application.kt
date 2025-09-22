package com.example.smarttransport.user.application

import android.app.Application
import android.content.SharedPreferences
import com.example.smarttransport.di.modules.classesModule
import com.example.smarttransport.di.modules.networkModule
import com.example.smarttransport.di.modules.preferencesModule
import com.example.smarttransport.di.modules.viewModelModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class Application : Application() {

    companion object {
        var language: String = "ar"
        var appTheme: String = "light"
    }

    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@Application)
            modules(networkModule, preferencesModule, viewModelModule, classesModule)
        }

        // بعد ما Koin اشتغل، تقدر تجيب SharedPreferences
        val sharedPreferences: SharedPreferences = org.koin.java.KoinJavaComponent.get(SharedPreferences::class.java)

        language = if (sharedPreferences.getString("lang", "ar") == "en") {
            "en"
        } else {
            "ar"
        }

        appTheme = if (sharedPreferences.getString("theme", "light") == "light") {
            "light"
        } else {
            "dark"
        }
    }
}
