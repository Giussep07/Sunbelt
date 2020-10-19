package com.giussepr.sunbelt.ui.home

import androidx.paging.PagingSource
import com.giussepr.sunbelt.db.entity.PixabayImage
import com.giussepr.sunbelt.dto.PixabayResDTO
import retrofit2.Response

interface IContractHome {

    interface ViewModel {
    }

    interface Repository {
        suspend fun getImages(page: Int, perPage: Int, language: String): Response<PixabayResDTO>
        fun insertPixabayImages(pixabayImage: List<PixabayImage>?)
    }
}