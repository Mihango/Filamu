package com.techmashinani.filamu.api

import com.techmashinani.filamu.model.Movie
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MovieApiService {

    @GET("/movie/latest")
    fun getLatestMovies(): Deferred<Movie>

    @GET("movie/upcoming")
    fun getUpcomingMovies(): Deferred<List<Movie>>
}