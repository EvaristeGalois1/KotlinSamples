package com.georgcantor.kotlinsamples.viewmodel.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {

    companion object {
        const val BASE_URL: String = "https://api.androidhive.info/json/"
        private const val REQUEST_TIMEOUT = 60
        private var okHttpClient: OkHttpClient? = null

        fun getClient(): Retrofit {
            initOkHttp()

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit
        }

        private fun initOkHttp() {
            val httpClient = OkHttpClient().newBuilder()
                    .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            httpClient.addInterceptor(interceptor)

            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Request-Type", "Android")
                        .addHeader("Content-Type", "application/json")

                val request = requestBuilder.build()
                chain.proceed(request)
            }

            okHttpClient = httpClient.build()
        }
    }
}