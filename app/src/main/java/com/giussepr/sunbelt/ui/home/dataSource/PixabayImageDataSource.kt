package com.giussepr.sunbelt.ui.home.dataSource

import androidx.paging.PagingSource
import com.giussepr.sunbelt.db.entity.PixabayImage
import com.giussepr.sunbelt.dto.PixabayImageResDTO
import com.giussepr.sunbelt.ui.home.IContractHome
import com.giussepr.sunbelt.utility.ErrorGetImages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class PixabayImageDataSource constructor(
    private val repository: IContractHome.Repository
) : PagingSource<Int, PixabayImage>() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PixabayImage> {
        try {
            val nextPage = params.key ?: 1
            val response = repository.getImages(
                nextPage,
                30,
                "en"
            )

            return if (response.isSuccessful) {
                coroutineScope.launch {
                    if (response.body() != null) {
                        repository.insertPixabayImages(
                            PixabayImageResDTO.toListPixabayImageModel(
                                response.body()!!.hits
                            )
                        )
                    }
                }
                LoadResult.Page(
                    data = PixabayImageResDTO.toListPixabayImageModel(
                        response.body()?.hits ?: ArrayList()
                    ),
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = nextPage + 1
                )
            } else {
                Timber.e("No hay imagenes, ${response.errorBody()?.string()}")
                LoadResult.Error(
                    ErrorGetImages(
                        response.errorBody()?.string() ?: "Error obteniendo imagenes"
                    )
                )
            }
        } catch (e: Exception) {
            Timber.e(e)
            return LoadResult.Error(e)
        }
    }
}