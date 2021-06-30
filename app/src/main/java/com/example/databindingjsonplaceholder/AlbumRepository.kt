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

    private val data: MutableLiveData<List<Photo>> = MutableLiveData()

    fun getData() {
        apiClient.getPhotos().enqueue(object : Callback<List<Photo>> {
            override fun onResponse(
                call: Call<List<Photo>>,
                response: Response<List<Photo>>
            ) {
                Log.d(TAG, "Called")
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.d(TAG, "Called ${t.localizedMessage}")

            }

        })
    }

    val observeData: LiveData<List<Photo>>
        get() = data
}