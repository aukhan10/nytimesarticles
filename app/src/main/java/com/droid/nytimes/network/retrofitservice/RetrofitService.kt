package com.droid.nytimes.network.retrofitservice

import android.content.Context
import com.droid.nytimes.common.constant.AppConstants
import com.droid.nytimes.network.interceptors.NetworkConnectionInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitService(
    private val applicationContext: Context,
    private val appConstants: AppConstants
) {
    private var retrofit: Retrofit? = null

    fun <S> getInstance(serviceClass: Class<S>): S {
        if (retrofit == null) {
            retrofit = getRetrofitInstance()
        }
        return retrofit!!.create(serviceClass)
    }

    private fun getRetrofitInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

        applicationContext.let {
            clientBuilder.addInterceptor(NetworkConnectionInterceptor(it))
        }
        val client = clientBuilder.build()
        val builder = Retrofit.Builder()
        builder.baseUrl(appConstants.BaseURL)
        builder.addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
            )
        )
        builder.client(client)
        return builder.build()
    }
}