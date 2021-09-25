package com.example.unsplash.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplash.data.models.UnsplashImageList
import com.example.unsplash.repository.UnsplashRepository
import com.example.unsplash.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UnsplashRepository
) : ViewModel() {

    private val _imageList = MutableLiveData<UnsplashImageList>()
    val imageList: LiveData<UnsplashImageList> get() = _imageList

    private val itemCount: Int = 20

    init {
        viewModelScope.launch {
            when (val imageResponse = repository.getRandomImageList(itemCount.toString())) {
                is Resource.Succes -> _imageList.value = imageResponse.data
                is Resource.Error -> Log.e("MainViewModel", imageResponse.message.toString())
            }
        }
    }
}