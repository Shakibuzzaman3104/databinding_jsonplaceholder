package com.example.databindingjsonplaceholder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AlbumRepository {

    val apiClient = RetrofitClient.getInstance().create(ApiClient::class.java)

    private val TAG = javaClass.simpleName

    private val data: MutableLiveData<List<Album>> = MutableLiveData()

    fun getData() {
        apiClient.getPhotos().enqueue(object : Callback<List<Album>> {
            override fun onResponse(
                call: Call<List<Album>>,
                response: Response<List<Album>>
            ) {
                Log.d(TAG, "Called")
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Log.d(TAG, "Called ${t.localizedMessage}")

            }

        })
    }

    val observeData: LiveData<List<Album>>
        get() = data
}