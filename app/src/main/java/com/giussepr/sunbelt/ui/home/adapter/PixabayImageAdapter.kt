package com.giussepr.sunbelt.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.giussepr.sunbelt.databinding.HomeFragmentItemBinding
import com.giussepr.sunbelt.db.entity.PixabayImage

class PixabayImageAdapter(private val clickListener: (PixabayImage, ImageView) -> Unit) :
    PagingDataAdapter<PixabayImage, PixabayImageAdapter.PixabayImageViewHolder>(PixabayImage.DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixabayImageViewHolder {
        return PixabayImageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PixabayImageViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    class PixabayImageViewHolder constructor(private val binding: HomeFragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pixabayImage: PixabayImage, clickListener: (PixabayImage, ImageView) -> Unit) {
            binding.apply {
                this.pixabayImage = pixabayImage

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    this.imageViewImage.transitionName = pixabayImage.webFormatUrl
                }

                this.cardViewPixabayImage.setOnClickListener {
                    clickListener(
                        pixabayImage,
                        binding.imageViewImage
                    )
                }

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