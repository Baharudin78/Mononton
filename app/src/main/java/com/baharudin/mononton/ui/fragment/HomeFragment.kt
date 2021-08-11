package com.baharudin.mononton.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.baharudin.mononton.R
import com.baharudin.mononton.adapter.TopRatedAdapter
import com.baharudin.mononton.databinding.FragmentHomeBinding
import com.baharudin.mononton.ui.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val movieModel by viewModels<MovieViewModel> ()
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)


        val adaptorMovie = TopRatedAdapter()
        binding.apply {
            rvTopRated.setHasFixedSize(true)
            rvTopRated.adapter = adaptorMovie
        }
        movieModel.movie.observe(viewLifecycleOwner) {
            adaptorMovie.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

}