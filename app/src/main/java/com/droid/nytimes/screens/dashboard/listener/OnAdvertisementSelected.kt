package com.droid.nytimes.screens.dashboard.listener

import com.droid.nytimes.common.models.dto.AdvertisementModel


interface OnAdvertisementSelected {
    fun onClicked(model: AdvertisementModel)
}