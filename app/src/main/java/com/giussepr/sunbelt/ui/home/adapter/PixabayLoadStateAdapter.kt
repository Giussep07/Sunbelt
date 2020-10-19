package com.giussepr.sunbelt.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.giussepr.sunbelt.databinding.HomeFragmentLoadStateBinding

class PixabayLoadStateAdapter : LoadStateAdapter<PixabayLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder.from(parent)
    }

    class LoadStateViewHolder(private val binding: HomeFragmentLoadStateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            binding.progressBar.isVisible = loadState is LoadState.Loading
        }

        companion object {
            fun from(parent: ViewGroup): LoadStateViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HomeFragmentLoadStateBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )

                return LoadStateViewHolder(binding)
            }
        }
    }
}