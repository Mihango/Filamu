package com.techmashinani.filamu.repository

import com.techmashinani.filamu.api.MovieApiService
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.model.result.Result
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: MovieApiService) {

    suspend fun getMovies(): Result<Movie> {

        return try {
            val deferred =  apiService.getLatestMovies().await()
            Result.Success(deferred)
        } catch(e: Exception) {
            Result.Error(e)
        }
    }

    suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return try {
            val upcoming = apiService.getUpcomingMovies().await()
            return Result.Success(upcoming)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}