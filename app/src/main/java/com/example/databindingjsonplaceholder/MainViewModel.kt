package com.example.databindingjsonplaceholder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val repository: AlbumRepository = AlbumRepository()
    private val TAG = javaClass.simpleName

    fun getData() {
        Log.d(TAG, "getData: ")
        repository.getData()
    }

    val observeData: LiveData<List<Album>>
        get() = repository.observeData

}