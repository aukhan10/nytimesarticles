package com.droid.nytimes.common.di

import com.droid.nytimes.common.constant.AppConstants
import org.koin.dsl.module

val appModule = module {

    single {
        AppConstants()
    }

}