package com.giussepr.sunbelt.ui.splash

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.giussepr.sunbelt.R
import com.giussepr.sunbelt.databinding.SplashFragmentBinding
import java.util.concurrent.TimeUnit

class SplashFragment : Fragment() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    private val viewModel: SplashViewModel by viewModels()
    private lateinit var binding: SplashFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.splash_fragment, container, false
        )

        Handler().postDelayed({
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }, TimeUnit.SECONDS.toMillis(2))

        return binding.root
    }

}