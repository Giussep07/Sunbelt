package com.giussepr.sunbelt.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.giussepr.sunbelt.db.entity.PixabayImage
import com.giussepr.sunbelt.ui.home.dataSource.PixabayImageDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: IContractHome.Repository) :
    ViewModel(), IContractHome.ViewModel {
    private val pageSize: Int = 20

    val images: Flow<PagingData<PixabayImage>> = Pager(PagingConfig(pageSize = pageSize)) {
        PixabayImageDataSource(repository)
    }
        .flow
        .cachedIn(viewModelScope)
}