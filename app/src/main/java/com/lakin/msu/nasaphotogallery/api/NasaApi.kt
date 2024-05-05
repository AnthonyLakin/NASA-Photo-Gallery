package com.lakin.msu.nasaphotogallery.api

import retrofit2.http.GET

private const val API_KEY = "DEMO_KEY"
private const val TAG = "NasaApi"


interface NasaApi {
    @GET(
        "mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=$API_KEY"
    )
    suspend fun fetchPhotos(): GalleryItem
}