package com.techmashinani.filamu.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule {

    @Named("AppName")
    @Provides
    fun provideAppName() = "Filamu App"
}