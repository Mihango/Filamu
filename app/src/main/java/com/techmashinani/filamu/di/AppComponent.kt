package com.techmashinani.filamu.di

import android.app.Application
import com.techmashinani.filamu.FilamuApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app: FilamuApp): Builder
        fun build(): AppComponent
    }

    fun inject(app: Application)
}