package com.example.databindingjsonplaceholder.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.databindingjsonplaceholder.ApiClient
import com.example.databindingjsonplaceholder.model.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class AlbumRepository @Inject constructor(private val api:ApiClient) {

    private val TAG = javaClass.simpleName

    private val data: MutableLiveData<List<Photo>> = MutableLiveData()

    private val observeClick: MutableLiveData<Boolean> = MutableLiveData()

    val clickObserve: LiveData<Boolean>
        get() = observeClick

    fun getData() {
        observeClick.postValue(true)
        api.getPhotos().enqueue(object : Callback<List<Photo>> {
            override fun onResponse(
                call: Call<List<Photo>>,
                response: Response<List<Photo>>
            ) {
                Log.d(TAG, "Called")
                data.value = response.body()
                observeClick.postValue(false)
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.d(TAG, "Called ${t.localizedMessage}")

            }
        })
    }

    val observeData: LiveData<List<Photo>>
        get() = data
}