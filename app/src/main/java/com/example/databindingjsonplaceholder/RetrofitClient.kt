package com.example.databindingjsonplaceholder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private var retroFit: Retrofit? = null
        fun getInstance(): Retrofit {
            if (retroFit == null)
                retroFit = Retrofit
                    .Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build()

            return retroFit!!
        }


    }


}