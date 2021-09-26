package com.example.unsplash.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.unsplash.databinding.ActivityMainBinding
import com.example.unsplash.ui.adapter.ImageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup Recyclerview
        mainViewModel.imageList.observe(this, Observer { newImageList ->
            binding.rvImages.layoutManager = GridLayoutManager(applicationContext, 2)
            binding.rvImages.adapter =
                ImageAdapter(context = applicationContext, randomImageList = newImageList)
        })
    }
}