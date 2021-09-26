package com.example.unsplash.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.unsplash.data.models.UnsplashImage
import com.example.unsplash.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private var displayImage: UnsplashImage? = null

    private lateinit var binding: ActivityDetailBinding

    private val detailViewModel: DetailViewModel by viewModels { DetailViewModelFactory(displayImage) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup Back Button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Init passed image
        displayImage = intent.extras?.getParcelable("Image")

        //ImageView
        detailViewModel.imageUrl.observe(this, { newImageUrl ->
            Glide.with(this)
                .load(newImageUrl)
                .into(binding.ivImageDetail)
        })

        //Description textview
        detailViewModel.imageDescription.observe(this, { newImageDescription ->
            binding.tvImageDescription.text = newImageDescription
        })

        //Creator textview
        detailViewModel.imageUserName.observe(this, { newImageDescription ->
            binding.tvImageCreator.text = newImageDescription
        })

        //Created date textview
        detailViewModel.imageCreatedDate.observe(this, { newImageDescription ->
            binding.tvImageCreatedAt.text = newImageDescription
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}