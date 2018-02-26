package com.example.gabrielrosa.findmovie.application.common.injection

import com.example.gabrielrosa.findmovie.application.home.usecase.GetMovies
import com.example.gabrielrosa.findmovie.application.moviedetail.usecase.GetMovieDetail

/**
 * Created by gabrielrosa on 25/02/18.
 */
class InjectionUseCase {

    companion object {
        fun provideGetMovies() : GetMovies = GetMovies(InjectionRemoteDataSource.provideRemoteDataSource())
        fun provideGetMovieDetail(): GetMovieDetail = GetMovieDetail(InjectionRemoteDataSource.provideRemoteDataSource())
    }
}