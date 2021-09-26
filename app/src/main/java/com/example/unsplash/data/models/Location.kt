package com.example.unsplash.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Location(
    val city: @RawValue Any?,
    val country: @RawValue Any?,
    val name: @RawValue Any?,
    val position: Position,
    val title: @RawValue Any?
) : Parcelable