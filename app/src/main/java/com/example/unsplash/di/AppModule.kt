package com.example.unsplash.di

import com.example.unsplash.BuildConfig
import com.example.unsplash.data.UnsplashApi
import com.example.unsplash.repository.UnsplashRepository
import com.example.unsplash.repository.UnsplashRepositoryImpl
import com.example.unsplash.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .followRedirects(true)
        .followSslRedirects(true)
        .connectTimeout(30L, TimeUnit.SECONDS)
        .readTimeout(30L, TimeUnit.SECONDS)
        .writeTimeout(30L, TimeUnit.SECONDS)
        .apply {
            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BASIC
                addInterceptor(interceptor)
            }

            addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", Constants.AUTH_HEADER_KEY)
                    .build()
                chain.proceed(request)
            }
        }
        .build()

    @Singleton
    @Provides
    fun provideUnsplashApi(): UnsplashApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UnsplashApi::class.java)

    @Singleton
    @Provides
    fun provideUnsplashRepository(api: UnsplashApi): UnsplashRepository =
        UnsplashRepositoryImpl(api = api)

}