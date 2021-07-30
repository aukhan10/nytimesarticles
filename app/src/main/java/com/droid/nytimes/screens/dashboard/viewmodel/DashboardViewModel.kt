package com.droid.nytimes.screens.dashboard.viewmodel

import androidx.lifecycle.MutableLiveData
import com.droid.nytimes.common.base.viewmodel.BaseViewModel
import com.droid.nytimes.common.models.dto.AdvertisementModel
import com.droid.nytimes.common.repository.AdvertisementRepository
import kotlinx.coroutines.launch

class DashboardViewModel(private val advertisementRepository: AdvertisementRepository) :
    BaseViewModel() {
    val listAdvertisements = MutableLiveData<ArrayList<AdvertisementModel>>()

    init {
        getListAdvertisements()
    }
    fun getListAdvertisements() {
        isLoading.value = true
        showMessage.value = null
        coroutineScope.launch {
            val result = advertisementRepository.getAdvertisements()
            isLoading.value = false
            result?.let {
                if (it.successful) {
                    listAdvertisements.value = result.result
                } else {
                    showMessage.value = result.message
                }
            }
        }
    }
}