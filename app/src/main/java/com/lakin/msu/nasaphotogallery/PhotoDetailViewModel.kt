package com.lakin.msu.nasaphotogallery

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "PhotoDetailViewModel"

class PhotoDetailViewModel : ViewModel() {
    private var photoTitle: String = ""
    private var photoId: String = ""
    private var src: String = ""

    fun getPhotoTitle(): String {
        return photoTitle
    }

    fun setPhotoTitle(title: String) {
        Log.d(TAG, "Setting photoTitle: $title")
        photoTitle = title
    }

    fun getPhotoId(): String {
        return photoId
    }

    fun setPhotoId(id: String) {
        Log.d(TAG, "Setting photoId: $id")
        photoId = id
    }

    fun getSrc(): String {
        return src
    }

    fun setSrc(src: String) {
        Log.d(TAG, "Setting src: $src")
        this.src = src
    }
}
