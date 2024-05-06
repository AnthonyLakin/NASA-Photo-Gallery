package com.lakin.msu.nasaphotogallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import coil.load

class PhotoDetailFragment : Fragment() {
    private val viewModel: PhotoDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photo_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)

        viewModel.src.observe(viewLifecycleOwner) { src ->
            imageView.load(src) {
                placeholder(R.drawable.loading)
                error(R.drawable.error_placeholder)
            }
        }

        viewModel.photoTitle.observe(viewLifecycleOwner) { title ->
            textView.text = title
        }
    }
}
