package com.example.unsplash.data

import com.example.unsplash.data.models.UnsplashImageList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("/photos/random/")
    suspend fun getRandomImageList(@Query("count") imageCount: String): Response<UnsplashImageList>
}