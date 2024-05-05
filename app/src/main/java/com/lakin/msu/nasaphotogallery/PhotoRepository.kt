package com.lakin.msu.nasaphotogallery

import com.lakin.msu.nasaphotogallery.api.Photo
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import android.util.Log
import com.lakin.msu.nasaphotogallery.api.GalleryItem
import com.lakin.msu.nasaphotogallery.api.NasaApi

private const val TAG = "PhotoRepository"

class PhotoRepository {
    private val nasaApi: NasaApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        nasaApi = retrofit.create()
        Log.d(TAG, "Retrofit has been configured with base URL: https://api.flickr.com/")

    }

    suspend fun fetchPhotos(): List<Photo> =
        nasaApi.fetchPhotos().photos

}

