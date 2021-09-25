package com.example.unsplash.util

sealed class Resource<T>(val data: T?, val message: String?) {
    class Succes<T>(data: T) : Resource<T>(data, null)
    class Error<T>(message: String?) : Resource<T>(null, message)
}