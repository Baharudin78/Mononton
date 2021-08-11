package com.baharudin.mononton.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.baharudin.mononton.network.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    repository: MovieRepository
    ):ViewModel() {
        val movie = repository.getSomeTopRated().cachedIn(viewModelScope)
}