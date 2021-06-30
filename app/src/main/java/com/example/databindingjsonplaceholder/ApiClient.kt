package com.example.databindingjsonplaceholder

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("photos")
    fun getPhotos():Call<List<Album>>

}