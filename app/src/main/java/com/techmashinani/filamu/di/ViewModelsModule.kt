package com.techmashinani.filamu.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techmashinani.filamu.viewmodels.MainViewModel
import com.techmashinani.filamu.viewmodels.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindDashViewModel(userViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    internal abstract fun bindMovieDetailViewModel(detail: MovieDetailViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}