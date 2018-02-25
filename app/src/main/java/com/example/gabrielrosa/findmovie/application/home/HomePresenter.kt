package com.example.gabrielrosa.findmovie.application.home

import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.example.gabrielrosa.findmovie.application.home.usecase.GetMovies
import com.example.gabrielrosa.findmovie.infrastructure.remote.BaseCallback

/**
 * Created by gabrielrosa on 25/02/18.
 */
class HomePresenter(private val view: HomeContract.View, private val getMovies: GetMovies): HomeContract.Presenter {

    override fun loadMovies(title: String) {
        view.showLoader()
        getMovies.loadMovies(title, object : BaseCallback.ApiCaseCallback<List<Movie>> {
            override fun onSuccess(response: List<Movie>) {
                view.hideLoader()
                view.showMovies(response)
            }

            override fun onEmptyData() {
                view.hideLoader()
                view.showNoMovies()
            }

            override fun onError() {
                view.hideLoader()
                view.showErrorMessage("error")
            }
        })


    }
}