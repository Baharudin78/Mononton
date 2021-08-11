package com.baharudin.mononton.di

import com.baharudin.mononton.network.MovieApi
import com.baharudin.mononton.network.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideRepository(movieApi: MovieApi) : MovieRepository = MovieRepository(movieApi)
}