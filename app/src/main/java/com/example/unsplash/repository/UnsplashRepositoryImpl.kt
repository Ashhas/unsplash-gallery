package com.example.unsplash.repository

import android.util.Log
import com.example.unsplash.data.UnsplashApi
import com.example.unsplash.data.models.UnsplashImageList
import com.example.unsplash.util.Resource
import java.lang.Exception
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(
    private val api: UnsplashApi
) : UnsplashRepository {

    override suspend fun getRandomImageList(imageCount: String): Resource<UnsplashImageList> {
        return try {
            val response = api.getRandomImageList(imageCount)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Log.d("UnsplashRepositoryImpl", "Request Finished Successfully")
                Resource.Succes(result)
            } else {
                Log.d("UnsplashRepositoryImpl", "Request Finished but Failed")
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "There is an error")
        }
    }
}