package com.lakin.msu.nasaphotogallery

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lakin.msu.nasaphotogallery.api.GalleryItem
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
            error(R.drawable.error_placeholder)
        }
    }
}



class PhotoListAdapter(
    private val photo: List<Photo>
) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = photo[position]
        holder.bind(item)
    }

    override fun getItemCount() = photo.size

}
