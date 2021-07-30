package com.droid.nytimes.common.di

import com.droid.nytimes.screens.articledetail.viewModel.AdvertisementDetailViewModel
import com.droid.nytimes.screens.dashboard.viewmodel.DashboardViewModel
import com.droid.nytimes.screens.splash.viewmodel.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel() {
        SplashViewModel()
    }
    viewModel() {
        DashboardViewModel(get())
    }
    viewModel() {
        AdvertisementDetailViewModel()
    }

}