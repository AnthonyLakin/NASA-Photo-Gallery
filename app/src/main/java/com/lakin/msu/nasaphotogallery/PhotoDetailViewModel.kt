package com.lakin.msu.nasaphotogallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
private const val TAG = "PhotoDetailViewModel"

class PhotoDetailViewModel : ViewModel() {
    private val _photoTitle = MutableLiveData<String>()
    val photoTitle: LiveData<String> get() = _photoTitle

    private val _photoId = MutableLiveData<String>()
    val photoId: LiveData<String> get() = _photoId

    private val _src = MutableLiveData<String>()
    val src: LiveData<String> get() = _src

    fun setPhotoTitle(title: String) {
        _photoTitle.value = title
        Log.d(TAG, "Photo title set to: $title")
    }

    fun setPhotoId(id: String) {
        _photoId.value = id
        Log.d(TAG, "Photo ID set to: $id")
    }

    fun setSrc(src: String) {
        _src.value = src
        Log.d(TAG, "Image source set to: $src")
    }
}
