package com.giussepr.sunbelt.dto

import com.giussepr.sunbelt.model.PixabayImage
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PixabayImageResDTO(
    @Json(name = "id") val id: Int,
    @Json(name = "pageURL") val pageUrl: String,
    @Json(name = "type") val type: String,
    @Json(name = "tags") val tags: String,
    @Json(name = "previewURL") val previewUrl: String,
    @Json(name = "previewWidth") val previewWidth: Int,
    @Json(name = "previewHeight") val previewHeight: Int,
    @Json(name = "webformatURL") val webFormatUrl: String,
    @Json(name = "webformatWidth") val webFormatWidth: Int,
    @Json(name = "webformatHeight") val webFormatHeight: Int,
    @Json(name = "largeImageURL") val largeImageUrl: String,
    @Json(name = "imageWidth") val imageWidth: Int,
    @Json(name = "imageHeight") val imageHeight: Int,
    @Json(name = "imageSize") val imageSize: Int,
    @Json(name = "views") val views: Int,
    @Json(name = "downloads") val downloads: Int,
    @Json(name = "favorites") val favorites: Int,
    @Json(name = "likes") val likes: Int,
    @Json(name = "comments") val comments: Int,
    @Json(name = "user_id") val userId: Int,
    @Json(name = "user") val user: String,
    @Json(name = "userImageURL") val userImageUrl: String
) {

    companion object {
        private fun toPixabayImageModel(pixabayImageResDTO: PixabayImageResDTO): PixabayImage {
            return with(pixabayImageResDTO) {
                PixabayImage(
                    id,
                    pageUrl,
                    type,
                    tags,
                    previewUrl,
                    previewWidth,
                    previewHeight,
                    webFormatUrl,
                    webFormatWidth,
                    webFormatHeight,
                    largeImageUrl,
                    imageWidth,
                    imageHeight,
                    imageSize,
                    views,
                    downloads,
                    favorites,
                    likes,
                    comments,
                    userId,
                    user,
                    userImageUrl
                )
            }
        }

        fun toListPixabayImageModel(pixabayImageResDTOList: List<PixabayImageResDTO>): List<PixabayImage> {
            val mutableListPixabayImage: MutableList<PixabayImage> = ArrayList()

            pixabayImageResDTOList.forEach { pixabayImageResDTO ->
                mutableListPixabayImage.add(
                    toPixabayImageModel(
                        pixabayImageResDTO
                    )
                )
            }

            return mutableListPixabayImage
        }
    }
}