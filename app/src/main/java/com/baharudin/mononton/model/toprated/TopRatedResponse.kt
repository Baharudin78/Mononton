package com.baharudin.mononton.model.toprated

data class TopRatedResponse(
    val page: Int,
    val topRatedResult: List<TopRated>,
    val total_pages: Int,
    val total_results: Int
)