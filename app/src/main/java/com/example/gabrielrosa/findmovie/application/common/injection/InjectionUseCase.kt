package com.example.gabrielrosa.findmovie.application.common.injection

import com.example.gabrielrosa.findmovie.application.home.usecase.GetMovies

/**
 * Created by gabrielrosa on 25/02/18.
 */
class InjectionUseCase {

    companion object {
        fun provideGetMovies() : GetMovies = GetMovies(InjectionRemoteDataSource.provideRemoteDataSource())
    }
}