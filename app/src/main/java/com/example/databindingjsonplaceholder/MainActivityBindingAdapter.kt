package com.example.databindingjsonplaceholder

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("photosList")
fun setPhotos(recyclerView: RecyclerView, photos: List<Album>?) {
    if (photos == null)
        return
    val layoutManager = recyclerView.layoutManager
    if (layoutManager == null)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 2)
    val adapter = PhotosAdapter()
    adapter.setData(photos)
    recyclerView.adapter = adapter
}


