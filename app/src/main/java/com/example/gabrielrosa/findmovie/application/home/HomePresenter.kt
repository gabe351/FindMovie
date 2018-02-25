package com.example.gabrielrosa.findmovie.application.home

import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.example.gabrielrosa.findmovie.application.common.injection.InjectionUseCase
import com.example.gabrielrosa.findmovie.application.home.usecase.GetMovies
import com.example.gabrielrosa.findmovie.infrastructure.remote.BaseCallback

/**
 * Created by gabrielrosa on 25/02/18.
 */
class HomePresenter(private val view: HomeContract.view, private val getMovies: GetMovies): HomeContract.presenter {

    override fun loadMovies(title: String) {
        getMovies.loadMovies(title, object : BaseCallback.ApiCaseCallback<List<Movie>> {
            override fun onSuccess(response: List<Movie>) {
                view.showMovies(response)
            }

            override fun onEmptyData() {
                view.showNoMovies()
            }

            override fun onError() {
                view.showErrorMessage("error")
            }
        })


    }
}