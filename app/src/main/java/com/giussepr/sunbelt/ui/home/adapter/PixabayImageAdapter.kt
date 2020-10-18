package com.giussepr.sunbelt.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.giussepr.sunbelt.databinding.HomeFragmentItemBinding
import com.giussepr.sunbelt.model.PixabayImage

class PixabayImageAdapter :
    ListAdapter<PixabayImage, PixabayImageAdapter.PixabayImageViewHolder>(PixabayImage.DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixabayImageViewHolder {
        return PixabayImageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PixabayImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PixabayImageViewHolder constructor(private val binding: HomeFragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pixabayImage: PixabayImage) {
            binding.apply {
                this.pixabayImage = pixabayImage

                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): PixabayImageViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HomeFragmentItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )

                return PixabayImageViewHolder(binding)
            }
        }
    }

}