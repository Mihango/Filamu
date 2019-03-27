package com.techmashinani.filamu.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techmashinani.filamu.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    fun getUpcomingMovies() {
        viewModelScope.launch {
            try {
                val movie = withContext(Dispatchers.IO) {
                    movieRepository.getUpcomingMovies()
                }
                Timber.e( "Movies size = ${movie.await().size}")
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}
