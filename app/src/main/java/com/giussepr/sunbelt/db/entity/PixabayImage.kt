package com.giussepr.sunbelt.db.entity

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PixabayImages")
data class PixabayImage(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "page_url") val pageUrl: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "tags") val tags: String,
    @ColumnInfo(name = "preview_url") val previewUrl: String,
    @ColumnInfo(name = "preview_width") val previewWidth: Int,
    @ColumnInfo(name = "preview_height") val previewHeight: Int,
    @ColumnInfo(name = "web_format_url") val webFormatUrl: String,
    @ColumnInfo(name = "web_format_width") val webFormatWidth: Int,
    @ColumnInfo(name = "web_format_height") val webFormatHeight: Int,
    @ColumnInfo(name = "large_image_url") val largeImageUrl: String,
    @ColumnInfo(name = "image_width") val imageWidth: Int,
    @ColumnInfo(name = "image_height") val imageHeight: Int,
    @ColumnInfo(name = "image_size") val imageSize: Int,
    @ColumnInfo(name = "views") val views: Int,
    @ColumnInfo(name = "downloads") val downloads: Int,
    @ColumnInfo(name = "favorites") val favorites: Int,
    @ColumnInfo(name = "likes") val likes: Int,
    @ColumnInfo(name = "comments") val comments: Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "user") val user: String,
    @ColumnInfo(name = "user_image_url") val userImageUrl: String
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