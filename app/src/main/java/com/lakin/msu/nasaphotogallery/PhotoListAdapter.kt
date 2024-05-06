import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lakin.msu.nasaphotogallery.PhotoDetailViewModel
import com.lakin.msu.nasaphotogallery.R
import com.lakin.msu.nasaphotogallery.api.Photo
import com.lakin.msu.nasaphotogallery.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding,
    private val viewModel: PhotoDetailViewModel
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo) {
        binding.itemImageView.load(photo.src) {
            placeholder(R.drawable.loading)
            error(R.drawable.error_placeholder)
        }

        binding.root.setOnClickListener {
            viewModel.setPhotoTitle(photo.camera.title)
            viewModel.setPhotoId(photo.id)
            viewModel.setSrc(photo.src)
        }
    }
}

class PhotoListAdapter(
    private var photos: List<Photo>,
    private val viewModel: PhotoDetailViewModel
) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = photos[position]
        holder.bind(item)
    }

    override fun getItemCount() = photos.size

    fun updateItems(newPhotos: List<Photo>) {
        this.photos = newPhotos
        notifyDataSetChanged()  // Notifying the adapter to re-evaluate the list
    }
}
