package com.droid.nytimes.common.di

import com.droid.nytimes.common.repository.AdvertisementRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        AdvertisementRepository(get())
    }
}