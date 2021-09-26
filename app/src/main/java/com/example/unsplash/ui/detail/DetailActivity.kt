package com.example.unsplash.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.unsplash.R
import com.example.unsplash.data.models.UnsplashImage
import com.example.unsplash.databinding.ActivityDetailBinding
import com.example.unsplash.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private var displayImage: UnsplashImage? = null

    private lateinit var binding: ActivityDetailBinding

    private val detailViewModel: DetailViewModel by viewModels { DetailViewModelFactory(displayImage) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Init passed image
        displayImage = intent.extras?.getParcelable<UnsplashImage>("Image")

        //ImageView
        detailViewModel.imageUrl.observe(this, Observer { newImageUrl ->
            Glide.with(this)
                .load(newImageUrl)
                .into(binding.ivImageDetail);
        })

        //Description textview
        detailViewModel.imageDescription.observe(this, Observer { newImageDescription ->
            binding.tvImageDescription.text = newImageDescription
        })

        //Creator textview
        detailViewModel.imageUserName.observe(this, Observer { newImageDescription ->
            binding.tvImageCreator.text = newImageDescription
        })

        //Created date textview
        detailViewModel.imageCreatedDate.observe(this, Observer { newImageDescription ->
            binding.tvImageCreatedAt.text = newImageDescription
        })


    }
}