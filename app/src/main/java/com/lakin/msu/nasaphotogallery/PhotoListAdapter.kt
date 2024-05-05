package com.lakin.msu.nasaphotogallery

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lakin.msu.nasaphotogallery.api.Photo
import com.lakin.msu.nasaphotogallery.databinding.ListItemGalleryBinding
import kotlin.math.min

private const val TAG = "PhotoListRepository"

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: Photo) {
        binding.itemImageView.load(photo.src) {
            placeholder(R.drawable.loading)
        }
    }
}

class PhotoListAdapter : RecyclerView.Adapter<PhotoViewHolder>() {
    private var photos: List<Photo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount() = photos.size

    fun submitList(newPhotos: List<Photo>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                photos[oldItemPosition].id == newPhotos[newItemPosition].id

            override fun getOldListSize() = photos.size

            override fun getNewListSize() = newPhotos.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                photos[oldItemPosition] == newPhotos[newItemPosition]
        })

        photos = newPhotos
        diffResult.dispatchUpdatesTo(this)
    }
}
