package com.baharudin.mononton.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.baharudin.mononton.paging.MoviePagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private var movieApi: MovieApi
) {
    fun getSomeTopRated() =
        Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(movieApi) }
        ).liveData
}