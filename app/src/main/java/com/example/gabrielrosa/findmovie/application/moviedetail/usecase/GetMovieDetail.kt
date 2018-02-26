package com.example.gabrielrosa.findmovie.application.moviedetail.usecase

import com.example.gabrielrosa.findmovie.infrastructure.model.MovieDetailResponse
import com.example.gabrielrosa.findmovie.infrastructure.remote.BaseCallback
import com.example.gabrielrosa.findmovie.infrastructure.remote.movie.remotedatasource.MovieRemoteDataSource

/**
 * Created by gabrielrosa on 25/02/18.
 */
class GetMovieDetail(private val remoteDataSource: MovieRemoteDataSource) {

    fun loadMovieDetail(id: Int, useCaseCallback: BaseCallback.ApiCaseCallback<MovieDetailResponse>) {
        remoteDataSource.loadMovie(id, useCaseCallback)
    }
}