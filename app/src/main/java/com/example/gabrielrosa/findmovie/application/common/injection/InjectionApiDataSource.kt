package com.example.gabrielrosa.findmovie.application.common.injection

import com.example.gabrielrosa.findmovie.infrastructure.remote.movie.apidatasource.MovieApiDataSourceImpl

/**
 * Created by gabrielrosa on 25/02/18.
 */
class InjectionApiDataSource {

    companion object {
        fun provideApiDataSource(): MovieApiDataSourceImpl = MovieApiDataSourceImpl.instance
    }
}