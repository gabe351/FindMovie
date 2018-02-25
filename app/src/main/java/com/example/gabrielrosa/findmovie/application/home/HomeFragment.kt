package com.example.gabrielrosa.findmovie.application.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielrosa.findmovie.R
import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.example.gabrielrosa.findmovie.application.common.injection.InjectionUseCase
import com.example.gabrielrosa.findmovie.application.home.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * Created by gabrielrosa on 24/02/18.
 */
class HomeFragment: Fragment(), HomeContract.View {

    private var moviesAdapter: MoviesAdapter?       = null
    private var mPresenter: HomeContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = HomePresenter(this, InjectionUseCase.provideGetMovies())
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesAdapter = MoviesAdapter(context, listOf())

        moviesRecyclerView.adapter       = moviesAdapter
        moviesRecyclerView.layoutManager = LinearLayoutManager(context)

        mainToolbarSetup()
        searchMovie()
    }

    override fun showMovies(movie: List<Movie>) {
        moviesAdapter?.replaceData(movie)
    }

    override fun showNoMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMessage(errorMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoader() {
        moviesProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        moviesProgressBar.visibility = View.GONE
    }

    private fun mainToolbarSetup() {
        if (moviesToolBar != null) {
            (activity as AppCompatActivity).setSupportActionBar(moviesToolBar)
            (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(false)
            (activity as AppCompatActivity).supportActionBar!!.setDisplayShowTitleEnabled(false)
        }
    }

    private fun searchMovie() {
        moviesSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0 != null) {
                    mPresenter?.loadMovies(p0)
                }
                moviesSearchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
    }
}