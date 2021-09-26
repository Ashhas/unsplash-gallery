package com.example.unsplash.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unsplash.data.models.UnsplashImage

class DetailViewModelFactory(private val image: UnsplashImage?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(image) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}