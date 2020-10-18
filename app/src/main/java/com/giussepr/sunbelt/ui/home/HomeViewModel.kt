package com.giussepr.sunbelt.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giussepr.sunbelt.dto.PixabayImageResDTO
import com.giussepr.sunbelt.model.PixabayImage
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: IContractHome.Repository) :
    ViewModel(), IContractHome.ViewModel {

    private val _pixabayImages = MutableLiveData<List<PixabayImage>>()
    val pixabayImages: LiveData<List<PixabayImage>>
        get() = _pixabayImages

    override fun getImages() {
        viewModelScope.launch {
            val response = repository.getImages(
                page = 1,
                perPage = 20,
                language = "es"
            )

            if (response.isSuccessful) {
                response.body()?.let { responseBody ->
                    _pixabayImages.value =
                        PixabayImageResDTO.toListPixabayImageModel(responseBody.hits)
                }
            } else {
                Timber.e(response.errorBody().toString())
            }

        }
    }
}