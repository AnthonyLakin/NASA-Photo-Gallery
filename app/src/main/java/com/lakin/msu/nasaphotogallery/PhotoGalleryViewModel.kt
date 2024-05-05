package com.lakin.msu.nasaphotogallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lakin.msu.nasaphotogallery.api.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.math.min

private const val TAG = "PhotoGalleryViewModel"

class PhotoGalleryViewModel : ViewModel() {
    private val photoRepository = PhotoRepository()

    private val _photos: MutableStateFlow<List<Photo>> = MutableStateFlow(emptyList())
    val photos: StateFlow<List<Photo>> get() = _photos.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val photos = photoRepository.fetchPhotos() // Directly fetches List<Photo>
                _photos.value = photos
                /*for (i in 0 until min(photos.size, 10)) {
                    Log.d(TAG, "Photo ${i + 1}: ID=${photos[i].id}, Title=${photos[i].camera.title}, Src=${photos[i].src}")
                }*/

            } catch (ex: Exception) {
                Log.e(TAG, "Failed to fetch photos", ex)
            }
        }
    }
}
