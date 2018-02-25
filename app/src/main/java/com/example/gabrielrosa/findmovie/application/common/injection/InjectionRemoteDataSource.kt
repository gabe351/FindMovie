package com.example.gabrielrosa.findmovie.application.common.injection

import com.example.gabrielrosa.findmovie.infrastructure.remote.movie.remotedatasource.MovieRemoteDataSource
import com.example.gabrielrosa.findmovie.infrastructure.remote.movie.remotedatasource.MovieRemoteDataSourceImpl

/**
 * Created by gabrielrosa on 25/02/18.
 */
class InjectionRemoteDataSource {

    companion object {
        fun provideRemoteDataSource(): MovieRemoteDataSource = MovieRemoteDataSourceImpl(InjectionApiDataSource.provideApiDataSource())
    }
}