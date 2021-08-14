package com.example.databindingjsonplaceholder.interfaces

import com.example.databindingjsonplaceholder.model.Photo

interface OnPhotoClickListener {
    fun onClick(photo: Photo, position:Int)
}