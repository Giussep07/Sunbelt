package com.giussepr.sunbelt.ui.imageDetail

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.giussepr.sunbelt.R
import com.giussepr.sunbelt.databinding.ImageDetailFragmentBinding

class ImageDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ImageDetailFragment()
    }

    private lateinit var viewModel: ImageDetailViewModel
    private lateinit var binding: ImageDetailFragmentBinding
    private val navArgs: ImageDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.image_detail_fragment, container, false
        )

        binding.pixabayImage = navArgs.pixabayImage

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageViewImage.apply {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                transitionName = navArgs.pixabayImage.webFormatUrl
            }

            startEnterTransitionAfterLoadingImage(navArgs.pixabayImage.webFormatUrl, this)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun setSharedElementTransitionOnEnter(){
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_element_transition)
    }

    private fun startEnterTransitionAfterLoadingImage(
        imageAddress: String,
        imageView: ImageView
    ) {
        Glide.with(requireContext())
            .load(imageAddress)
            .into(imageView)
    }

}