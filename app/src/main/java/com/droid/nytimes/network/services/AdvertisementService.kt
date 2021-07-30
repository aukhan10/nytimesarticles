package com.droid.nytimes.network.services

import com.droid.nytimes.common.models.response.GetAdvertisementApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface AdvertisementService {

    @GET("mostpopular/v2/mostviewed/all-sections/7.json?api-key=lqAmIosFAkFSmsIyBYr2EF5b5lO5R2F0")
    suspend fun getMostPopularArticles(): Response<GetAdvertisementApiResponse>
}