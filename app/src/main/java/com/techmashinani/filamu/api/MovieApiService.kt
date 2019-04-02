package com.techmashinani.filamu.api

import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.model.response.ResultResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MovieApiService {

    @GET("/movie/latest")
    fun getLatestMovies(): Deferred<Movie>

    @GET("movie/upcoming")
    fun getUpcomingMovies(): Deferred<ResultResponse<Movie>>

    @GET("")
    fun getBestSeries(): Deferred<ResultResponse<Movie>>

    @GET("")
    fun getBestMovies(): Deferred<ResultResponse<Movie>>
}