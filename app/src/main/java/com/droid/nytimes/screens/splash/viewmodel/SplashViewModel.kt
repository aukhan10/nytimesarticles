package com.droid.nytimes.screens.splash.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.droid.nytimes.common.base.viewmodel.BaseViewModel

class SplashViewModel() : BaseViewModel() {
    val navigateToDashboard = MutableLiveData<Boolean>()

    init {
        splashDelayed()
    }

    private fun splashDelayed() {
        Handler().postDelayed({
            navigateToDashboard.value = true
        }, 1000)
    }

}