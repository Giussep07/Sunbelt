package com.giussepr.sunbelt.ui.home

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.giussepr.sunbelt.R
import com.giussepr.sunbelt.databinding.HomeFragmentBinding
import com.giussepr.sunbelt.ui.home.adapter.PixabayImageAdapter
import com.giussepr.sunbelt.ui.home.adapter.PixabayLoadStateAdapter
import com.giussepr.sunbelt.utility.viewModel.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    private lateinit var binding: HomeFragmentBinding
    private lateinit var adapter: PixabayImageAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )

        setupAdapter()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.images.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun setupAdapter() {
        adapter = PixabayImageAdapter(clickListener = { pixabayImage, imageview ->
            val extraInfo = FragmentNavigatorExtras(
                imageview to pixabayImage.webFormatUrl
            )

            this.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToImageDetailFragment(pixabayImage),
                extraInfo
            )
        })

        binding.recyclerViewPixabayImages.adapter = adapter.withLoadStateFooter(
            footer = PixabayLoadStateAdapter()
        )

        adapter.addLoadStateListener { loadState ->

            if (loadState.refresh is LoadState.Loading) {
                binding.progressBar.isVisible = true
            } else {
                binding.progressBar.isVisible = false

                val error = when {
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                error?.let {
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        postponeEnterTransition()

        binding.recyclerViewPixabayImages.viewTreeObserver.addOnPreDrawListener {

            startPostponedEnterTransition()

            true
        }

    }

}