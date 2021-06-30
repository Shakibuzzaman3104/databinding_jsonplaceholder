package com.example.databindingjsonplaceholder

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


@BindingAdapter("photosList")
fun setPhotos(recyclerView: RecyclerView, photos: List<Photo>?) {
    if (photos == null)
        return
    val layoutManager = recyclerView.layoutManager
    if (layoutManager == null)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 2)
    val adapter = PhotosAdapter()
    adapter.setData(photos)
    recyclerView.adapter = adapter
}

@BindingAdapter("imageUrl")
fun setImage(image: ImageView, url: String) {
    Glide.with(image.context)
        .load("$url.png")
        .into(image)
}


