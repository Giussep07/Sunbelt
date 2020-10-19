package com.giussepr.sunbelt.ui.home.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.giussepr.sunbelt.R

@BindingAdapter("pixabayImage")
fun bindPixabayImage(imageView: ImageView, imageUrl: String) {

    Glide.with(imageView)
        .load(imageUrl)
        .into(imageView)
}

@BindingAdapter("avatar")
fun bindAvatar(imageView: ImageView, avatarUrl: String) {
    Glide.with(imageView)
        .load(if (avatarUrl.isEmpty()) R.drawable.ic_default_avatar else avatarUrl)
        .transform(CircleCrop())
        .into(imageView)
}