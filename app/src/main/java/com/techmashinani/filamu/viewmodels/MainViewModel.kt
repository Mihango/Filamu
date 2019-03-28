package com.techmashinani.filamu.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techmashinani.filamu.model.result.Result
import com.techmashinani.filamu.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : BaseViewModel() {

    fun getUpcomingMovies() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val movie = withContext(Dispatchers.IO) {
                movieRepository.getUpcomingMovies()
            }

            when(movie) {
                is Result.Success -> {
                    Timber.e( "Movies size = ${movie.data.size}")
                    isLoading.postValue(false)
                }
                is Result.Error -> {
                    isLoading.postValue(false)
                    errorLiveData.postValue(movie.exception.message)
                }
            }
        }
    }
}
