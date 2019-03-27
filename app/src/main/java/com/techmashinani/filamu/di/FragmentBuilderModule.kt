package com.techmashinani.filamu.di

import com.techmashinani.filamu.ui.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindDashFragment(): MainFragment
}
