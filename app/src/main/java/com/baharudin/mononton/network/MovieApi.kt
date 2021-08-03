package com.baharudin.mononton.network

import com.baharudin.mononton.model.toprated.TopRatedResponse
import com.baharudin.mononton.network.Constant.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("movie/top_rated?api_key=$API_KEY")
    suspend fun getTopRated() : Response<TopRatedResponse>
}