package com.example.gabrielrosa.findmovie.application.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        searchMovie()
    }

    override fun showMovies(movie: List<Movie>) {
        moviesRecyclerView.visibility = View.VISIBLE
        emptyDataText.visibility      = View.GONE
        moviesAdapter?.replaceData(movie)
    }

    override fun showNoMovies() {
        moviesRecyclerView.visibility = View.GONE
        emptyDataText.visibility      = View.VISIBLE
    }

    override fun showErrorMessage(errorMessage: String) {
        Toast.makeText(activity, resources.getString(R.string.error_message), Toast.LENGTH_LONG).show();
    }

    override fun showLoader() {
        moviesProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        moviesProgressBar.visibility = View.GONE
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