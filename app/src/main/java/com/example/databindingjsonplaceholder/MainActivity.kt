package com.example.databindingjsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingjsonplaceholder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

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
}