package com.lakin.msu.nasaphotogallery

import com.lakin.msu.nasaphotogallery.api.GalleryItem
import com.lakin.msu.nasaphotogallery.api.NasaApi
import com.lakin.msu.nasaphotogallery.api.Photo
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import android.util.Log
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

private const val TAG = "PhotoRepository"

class PhotoRepository {
    private val nasaApi: NasaApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        nasaApi = retrofit.create(NasaApi::class.java)
        Log.d(TAG, "Retrofit has been configured with base URL: https://api.nasa.gov/")
    }

    suspend fun fetchPhotos(): List<Photo> = filterCameras()

    private suspend fun filterCameras(): List<Photo> = coroutineScope {
        val cameras = listOf("FHAZ", "RHAZ", "chemcam", "MAHLI", "MARDI", "NAVCAM", "PANCAM", "MINITES", "MAST")
        cameras.map { camera ->
            async {
                try {
                    Log.d(TAG, "Fetching photos for camera: $camera")
                    nasaApi.fetchPhotos(camera = camera).photos
                } catch (e: Exception) {
                    Log.e(TAG, "Error fetching photos for camera $camera: ${e.message}")
                    emptyList<Photo>()
                }
            }
        }.awaitAll().flatten() // Combine all lists into a single list of Photos
    }
}
