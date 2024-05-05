package com.lakin.msu.nasaphotogallery.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

private const val TAG = "GalleryItem"


@JsonClass(generateAdapter = true)
data class GalleryItem(
    val photos: List<Photo>
)

@JsonClass(generateAdapter = true)
data class Photo(
    val id: String,
    val camera: Camera,
    @Json(name = "img_src") val src: String
)

@JsonClass(generateAdapter = true)
data class Camera(
    @Json(name = "full_name") val title: String
)