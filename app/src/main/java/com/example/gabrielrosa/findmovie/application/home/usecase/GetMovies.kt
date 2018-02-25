package com.example.gabrielrosa.findmovie.application.home.usecase

import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.example.gabrielrosa.findmovie.infrastructure.remote.BaseCallback
import com.example.gabrielrosa.findmovie.infrastructure.remote.movie.remotedatasource.MovieRemoteDataSource

/**
 * Created by gabrielrosa on 25/02/18.
 */
class GetMovies(private val remoteDataSource: MovieRemoteDataSource) {

    fun loadMovies(query: String, useCaseCallback: BaseCallback.ApiCaseCallback<List<Movie>>) {
        remoteDataSource.loadMovies(query, useCaseCallback)
    }
}