package com.example.myapp.api

import com.example.myapp.model.ObjectModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("objects")
    fun getObjects(): Call<List<ObjectModel>>

    companion object {
        private const val BASE_URL = "https://api.restful-api.dev/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
