package com.lakin.msu.nasaphotogallery.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun fetchPhotos(
        @Query("sol") sol: Int = 50,
        @Query("camera") camera: String,
        @Query("api_key") apiKey: String = "DEMO_KEY"
    ): GalleryItem
}
