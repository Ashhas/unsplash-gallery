package com.example.unsplash.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.unsplash.data.models.UnsplashImage
import com.example.unsplash.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import android.content.Intent
import android.net.Uri
import com.example.unsplash.util.Constants.IMAGE_PARCEL_KEY


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
        displayImage = intent.extras?.getParcelable(IMAGE_PARCEL_KEY)

        //ImageView
        detailViewModel.imageUrl.observe(this, { imageUrl ->
            loadImageIntoView(imageUrl)
        })

        //Description textview
        detailViewModel.imageDescription.observe(this, { imageDescription ->
            binding.tvImageDescription.text = imageDescription
        })

        //Creator textview
        detailViewModel.imageUserName.observe(this, { creatorName ->
            binding.tvImageCreator.text = creatorName
        })

        //Created date textview
        detailViewModel.imageCreatedDate.observe(this, { imageCreationDate ->
            binding.tvImageCreatedAt.text = imageCreationDate
        })

        //URL Button
        detailViewModel.imageUnsplashUrl.observe(this, { imageWebsiteUrl ->
            binding.btnOpenUrl.setOnClickListener {
                openUnsplashWebsiteUrl(imageWebsiteUrl)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun loadImageIntoView(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .into(binding.ivImageDetail)
    }

    private fun openUnsplashWebsiteUrl(imageWebsiteUrl: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(imageWebsiteUrl)))
    }
}