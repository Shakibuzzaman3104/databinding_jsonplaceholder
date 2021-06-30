package com.example.databindingjsonplaceholder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val repository: AlbumRepository = AlbumRepository()
    private val TAG = javaClass.simpleName


    val clickObserve: LiveData<Boolean>
        get() = repository.clickObserve

    fun getData() {
        repository.getData()
    }

    val observeData: LiveData<List<Photo>>
        get() = repository.observeData

}