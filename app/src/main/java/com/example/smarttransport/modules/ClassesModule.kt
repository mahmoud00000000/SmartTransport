package com.example.smarttransport.di.modules

import com.example.smarttransport.user.data.reporsitory.MainRepository
import com.example.smarttransport.utils.AppManger
import org.koin.dsl.module

val classesModule = module {
    single { MainRepository(get()) }
    single { AppManger(get()) }
}