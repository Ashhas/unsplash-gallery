package com.example.unsplash.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplash.data.models.UnsplashImage
import com.example.unsplash.data.models.UnsplashImageList
import com.example.unsplash.databinding.GridImageItemBinding
import com.example.unsplash.ui.detail.DetailActivity

class ImageAdapter(private val context: Context, private val randomImageList: UnsplashImageList) :
    RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = GridImageItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val randomImage: UnsplashImage = randomImageList[position]
        holder.bind(randomImage)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra("Image", randomImage)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return randomImageList.size
    }

    inner class ImageHolder(private val itemBinding: GridImageItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(randomImage: UnsplashImage) {
            Glide.with(context)
                .load(randomImage.urls?.regular)
                .into(itemBinding.ivImage);
        }
    }
}