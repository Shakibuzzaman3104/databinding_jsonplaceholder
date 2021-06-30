package com.example.databindingjsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingjsonplaceholder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnPhotoClickListener {

    private lateinit var binding:ActivityMainBinding
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            this.lifecycleOwner = this@MainActivity
            this.viewmodel = mainViewModel
        }
    }

    private val mainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onClick(photo: Photo, position: Int) {
        Toast.makeText(this,"Id: ${photo.id} : position: $position",Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Id: ${photo.id} : position: $position")
    }
}