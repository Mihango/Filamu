package com.techmashinani.filamu.repository

import com.techmashinani.filamu.api.MovieApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: MovieApiService) {

    fun getMovies() = apiService.getLatestMovies()

    fun getUpcomingMovies() = apiService.getUpcomingMovies()
}