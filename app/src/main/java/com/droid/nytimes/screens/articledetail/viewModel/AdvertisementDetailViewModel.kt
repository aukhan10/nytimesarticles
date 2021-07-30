package com.droid.nytimes.screens.articledetail.viewModel

import androidx.lifecycle.MutableLiveData
import com.droid.nytimes.common.base.viewmodel.BaseViewModel
import com.droid.nytimes.common.models.dto.AdvertisementModel


class AdvertisementDetailViewModel() : BaseViewModel() {
    val advertisementModel = MutableLiveData<AdvertisementModel>()
    val readDataFromBundle = MutableLiveData<Boolean>()

    init {
        readDataFromBundle.value = true
    }

    fun setAdvertisementDetailModel(model: AdvertisementModel) {
        advertisementModel.value = model
    }
}