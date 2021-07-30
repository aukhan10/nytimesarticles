package com.droid.nytimes.screens.splash.activity

import android.content.Intent
import androidx.lifecycle.Observer
import com.droid.nytimes.common.base.activity.AppBaseActivity
import com.droid.nytimes.R
import com.droid.nytimes.screens.dashboard.activity.DashboardActivity
import com.droid.nytimes.screens.splash.viewmodel.SplashViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class SplashActivity : AppBaseActivity() {
    private lateinit var viewModel: SplashViewModel
    override fun init() {
        viewModel = getViewModel()
    }

    override fun setEvents() {
    }

    override fun setObservers() {
        viewModel.navigateToDashboard.observe(this, Observer {
            if (it) {
                finish()
                startAnotherActivity(Intent(this, DashboardActivity::class.java))
            }
        })
    }

    override fun getLayoutResId() = R.layout.activity_splash
}