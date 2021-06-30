package com.example.databindingjsonplaceholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingjsonplaceholder.databinding.ItemPhotoBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    private var photos: ArrayList<Photo> = ArrayList()

    fun setData(photos: List<Photo>) {
        this.photos.clear()
        this.photos.addAll(photos)
    }


    class ViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder)
        {
            this.binding.photo = photos[position]
            this.binding.position = position
            this.binding.click=holder.binding.root.context as OnPhotoClickListener
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}