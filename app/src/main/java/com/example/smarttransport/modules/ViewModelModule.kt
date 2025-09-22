package com.example.smarttransport.di.modules




import android.content.ContentResolver
import com.example.smarttransport.ui.viewmodel.AuthViewModel
import com.example.smarttransport.ui.viewmodel.SplashViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel



val viewModelModule = module {
    viewModel { AuthViewModel(get(),get()) }
    viewModel { SplashViewModel(get(),get(),get()) }
//    viewModel { ProductViewModel(get(), get()) }
//    viewModel { DetailsViewModel(get(), get(), get(), get(), get()) }
//    viewModel { CartViewModel(get(), get(), get(), get(), get()) }
//    viewModel { AddressViewModel(get(),get(),get(),get()) }
//    viewModel { BillingViewModel(get(), get(),get(), get()) }
//    viewModel { UserAccountViewModel(get(),get(),get(),get(),get()) }
//    viewModel { OrderViewModel(get(),get(),get(),get()) }
//    viewModel { ProfileViewModel(get(),get(),get(),get()) }
//    viewModel { SearchViewModel(get(),get(),get()) }
//    //viewModel { SearchViewModel(get(),get()) }
//    //viewModel { HomeViewModel(get(),get()) }
//    //viewModel { AddressViewModel(get(),get()) }
//    //viewModel { ProductDetailsViewModel(get(),get()) }
//    //viewModel { CartViewModel(get(),get()) }
//    //viewModel { OrderViewModel(get(),get()) }
//
    single { FirebaseFirestore.getInstance() }
    single { FirebaseAuth.getInstance() }
    single { FirebaseStorage.getInstance() } // ✅ أضف دي

    single<ContentResolver> { androidContext().contentResolver }

}
