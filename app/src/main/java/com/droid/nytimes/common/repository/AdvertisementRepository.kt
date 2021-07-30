package com.droid.nytimes.common.repository

import com.droid.nytimes.common.base.repository.BaseRepository
import com.droid.nytimes.common.constant.AppConstants
import com.droid.nytimes.common.models.response.GetAdvertisementApiResponse
import com.droid.nytimes.network.services.AdvertisementService
import java.util.*


open class AdvertisementRepository(
    private val advertisementService: AdvertisementService
) : BaseRepository() {


    suspend fun getAdvertisements(): GetAdvertisementApiResponse? {
        var model: GetAdvertisementApiResponse? = null
        try {
            val response = advertisementService.getMostPopularArticles()
            if (response.isSuccessful) {
                model = response.body()
                model?.let {
                    it.successful = true
                }
            }
        } catch (exp: Exception) {
            model = GetAdvertisementApiResponse()
            model.let {
                it.successful = false
                it.message = exp.message
            }

        }
        return model
    }
}