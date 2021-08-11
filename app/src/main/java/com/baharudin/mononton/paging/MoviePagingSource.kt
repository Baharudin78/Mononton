package com.baharudin.mononton.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.baharudin.mononton.model.toprated.TopRated
import com.baharudin.mononton.network.MovieApi
import retrofit2.HttpException
import java.io.IOException


const val STARTING_PAGE_INDEX = 1

class MoviePagingSource(
    private var movieApi : MovieApi
) : PagingSource<Int, TopRated>() {
    override fun getRefreshKey(state: PagingState<Int, TopRated>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopRated> {
        return try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val response = movieApi.getSomeTopRated(position)
            val movies = response.topRatedResult

            LoadResult.Page(
                data = movies,
                prevKey = if(position == STARTING_PAGE_INDEX) null else position -1,
                nextKey = if(movies.isEmpty()) null else position +1
            )
        }catch (e : IOException) {
            LoadResult.Error(e)
        }catch (e : HttpException) {
            LoadResult.Error(e)
        }
    }
}