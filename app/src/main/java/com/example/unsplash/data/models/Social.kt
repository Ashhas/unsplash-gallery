package com.example.unsplash.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Social(
    val instagram_username: String?,
    val paypal_email: @RawValue Any?,
    val portfolio_url: String?,
    val twitter_username: String?
) : Parcelable