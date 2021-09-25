package com.example.unsplash.repository

import com.example.unsplash.data.models.UnsplashImageList
import com.example.unsplash.util.Resource

interface UnsplashRepository {
    suspend fun getRandomImageList(imageCount: String): Resource<UnsplashImageList>
}