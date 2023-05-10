package com.example.healthcare_umc_160420046.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel


class ProfileViewModel(application: Application): AndroidViewModel(application) {
    var username: String? = null
    var lastLoginTime: String? = null
}