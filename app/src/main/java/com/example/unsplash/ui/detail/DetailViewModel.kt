package com.example.unsplash.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unsplash.data.models.UnsplashImage
import java.text.SimpleDateFormat
import java.util.*

class DetailViewModel constructor(
    randomImage: UnsplashImage?
) : ViewModel() {

    //ImageURL
    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String> get() = _imageUrl

    //ImageURL
    private val _imageUnsplashUrl = MutableLiveData<String>()
    val imageUnsplashUrl: LiveData<String> get() = _imageUnsplashUrl

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
        _imageUnsplashUrl.value = randomImage?.links?.html
        _imageDescription.value = randomImage?.description
        _imageUserName.value = randomImage?.user?.username
        _imageCreatedDate.value = formatDateTime(randomImage?.created_at)
    }

    private fun formatDateTime(dateTime: String?): String {
        val inputDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
        val outputDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH)

        val parsedDate = inputDateFormat.parse(dateTime!!)

        return outputDateFormat.format(parsedDate!!)
    }

}