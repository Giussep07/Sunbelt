package com.giussepr.sunbelt.model

import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json

data class PixabayImage(
    val id: Int,
    val pageUrl: String,
    val type: String,
    val tags: String,
    val previewUrl: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webFormatUrl: String,
    val webFormatWidth: Int,
    val webFormatHeight: Int,
    val largeImageUrl: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    val downloads: Int,
    val favorites: Int,
    val likes: Int,
    val comments: Int,
    val userId: Int,
    val user: String,
    val userImageUrl: String
) {
    object DiffCallback : DiffUtil.ItemCallback<PixabayImage>() {
        override fun areItemsTheSame(oldItem: PixabayImage, newItem: PixabayImage): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PixabayImage, newItem: PixabayImage): Boolean {
            return oldItem == newItem
        }
    }
}