package com.example.databindingjsonplaceholder

import com.example.databindingjsonplaceholder.model.Photo
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {

    @GET("photos")
    fun getPhotos():Call<List<Photo>>

}