package com.example.databindingjsonplaceholder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.databindingjsonplaceholder.repository.AlbumRepository
import com.example.databindingjsonplaceholder.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AlbumRepository): ViewModel() {

    private val TAG = javaClass.simpleName

    val clickObserve: LiveData<Boolean>
        get() = repository.clickObserve


    fun getData() {
        repository.getData()
    }

    val observeData: LiveData<List<Photo>>
        get() = repository.observeData

}