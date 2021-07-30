package com.droid.nytimes.common.di

import com.droid.nytimes.common.util.ImageUtil
import org.koin.dsl.module

val utilsModule = module {
    single {
        ImageUtil()
    }
}