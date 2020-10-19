package com.giussepr.sunbelt.repository.home

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.paging.PagingSource
import com.giussepr.sunbelt.BuildConfig
import com.giussepr.sunbelt.db.dao.PixabayImageDao
import com.giussepr.sunbelt.db.entity.PixabayImage
import com.giussepr.sunbelt.dto.PixabayResDTO
import com.giussepr.sunbelt.ui.home.IContractHome
import com.giussepr.sunbelt.webService.SunbeltApi
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val context: Context,
    private val sunbeltApi: SunbeltApi,
    private val pixabayImageDao: PixabayImageDao
) :
    IContractHome.Repository {


    override suspend fun getImages(
        page: Int,
        perPage: Int,
        language: String
    ): Response<PixabayResDTO> {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        return sunbeltApi.getPixabayImages(
            key = BuildConfig.PIXABAY_API_KEY,
            page = page,
            perPage = perPage,
            language = language
        )
    }

    override fun insertPixabayImages(pixabayImage: List<PixabayImage>?) {
        pixabayImage?.let {
            pixabayImageDao.insertPixabayImages(it)
        }
    }
}