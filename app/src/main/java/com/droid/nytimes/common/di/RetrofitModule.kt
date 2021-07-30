package com.droid.nytimes.common.di

import com.droid.nytimes.network.retrofitservice.RetrofitService
import com.droid.nytimes.network.services.AdvertisementService
import org.koin.dsl.module

val retrofitModule = module {

    single {
        RetrofitService(get(), get()).getInstance(AdvertisementService::class.java)
    }

}