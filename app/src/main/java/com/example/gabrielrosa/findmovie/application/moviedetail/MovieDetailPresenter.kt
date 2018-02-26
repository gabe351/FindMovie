package com.example.gabrielrosa.findmovie.application.moviedetail

import com.example.gabrielrosa.findmovie.application.moviedetail.usecase.GetMovieDetail
import com.example.gabrielrosa.findmovie.infrastructure.model.MovieDetailResponse
import com.example.gabrielrosa.findmovie.infrastructure.remote.BaseCallback

/**
 * Created by gabrielrosa on 25/02/18.
 */
class MovieDetailPresenter(private val view: MovieDetailContract.View, private val getMovieDetail: GetMovieDetail): MovieDetailContract.Presenter {


    override fun loadMovie(id: Int) {
        view.showLoader()
        getMovieDetail.loadMovieDetail(id, object : BaseCallback.ApiCaseCallback<MovieDetailResponse> {

            override fun onSuccess(response: MovieDetailResponse) {
                view.hideLoader()
                view.showMovie(response)
            }

            override fun onEmptyData() {
            }

            override fun onError() {
                view.hideLoader()
                view.showError()
            }
        })
    }
}