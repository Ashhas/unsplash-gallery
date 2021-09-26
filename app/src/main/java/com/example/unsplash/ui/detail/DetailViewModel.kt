package com.example.unsplash.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unsplash.data.models.UnsplashImage

class DetailViewModel constructor(
    private val randomImage: UnsplashImage?
) : ViewModel() {

    //ImageURL
    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String> get() = _imageUrl

    //Image Description
    private val _imageDescription = MutableLiveData<String>()
    val imageDescription: LiveData<String> get() = _imageDescription

    //Image UserName
    private val _imageUserName = MutableLiveData<String>()
    val imageUserName: LiveData<String> get() = _imageUserName

    //Image Created At
    private val _imageCreatedDate = MutableLiveData<String>()
    val imageCreatedDate: LiveData<String> get() = _imageCreatedDate

    init {
        _imageUrl.value = randomImage?.urls?.regular
        _imageDescription.value = randomImage?.description
        _imageUserName.value = randomImage?.user?.username
        _imageCreatedDate.value = randomImage?.created_at
    }

}