package com.chirikualii.materidb.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("movie/top_rated?api_key=3b980052023e8e6898f4578a6972740b&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<PopularMovieResponse>

    @GET("movie/now_playing?api_key=3b980052023e8e6898f4578a6972740b&language=en-US&page=1")
    suspend fun getNowPlayingMovie() :Response<PopularMovieResponse>

    @GET("search/movie?api_key=3b980052023e8e6898f4578a6972740b&language=en-US&page=1&include_adult=false")
    suspend fun getSearchMovie(
        @Query("query")
        query:String
    ) : Response<SearchMovieResponse>
}