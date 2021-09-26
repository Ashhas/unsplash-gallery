package com.example.unsplash.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class UnsplashImage(
    val alt_description: String?,
    val blur_hash: String?,
    val categories: @RawValue List<Any>?,
    val color: String?,
    val created_at: String?,
    val current_user_collections: @RawValue List<Any>?,
    val description: String?,
    val downloads: Int?,
    val exif: @RawValue Exif?,
    val height: Int?,
    val id: String?,
    val liked_by_user: Boolean?,
    val likes: Int?,
    val links: @RawValue Links?,
    val location: @RawValue Location?,
    val promoted_at: String?,
    val sponsorship: @RawValue Any?,
    val topic_submissions: @RawValue TopicSubmissions?,
    val updated_at: String?,
    val urls: @RawValue Urls?,
    val user: @RawValue User?,
    val views: Int?,
    val width: Int?
) : Parcelable