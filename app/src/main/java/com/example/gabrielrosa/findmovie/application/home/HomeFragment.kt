package com.example.gabrielrosa.findmovie.application.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielrosa.findmovie.R
import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.example.gabrielrosa.findmovie.application.home.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * Created by gabrielrosa on 24/02/18.
 */
class HomeFragment: Fragment(), HomeContract.view {


    private var moviesAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesAdapter = MoviesAdapter(context, buildFakeMovies())

        initial_text.text = "Hello World from fragment"


        moviesRecyclerView.adapter       = moviesAdapter
        moviesRecyclerView.layoutManager = LinearLayoutManager(context)

    }

    override fun showMovies(movie: List<Movie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMessage(errorMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun buildFakeMovies() : List<Movie> {

        val a = Movie(1, "Titulo 1", "/3iEciJiyczWPJ9770FHwRC3wokp.jpg", "Aqui temos o review do filme com um texto legal e tal na sua sessão da tarde")
        val b = Movie(2, "Titulo 1", "/3iEciJiyczWPJ9770FHwRC3wokp.jpg", "Aqui temos o review do filme com um texto legal e tal na sua sessão da tarde")
        val c = Movie(3, "Titulo 1", "/3iEciJiyczWPJ9770FHwRC3wokp.jpg", "Aqui temos o review do filme com um texto legal e tal na sua sessão da tarde")
        val d = Movie(4, "Titulo 1", "/3iEciJiyczWPJ9770FHwRC3wokp.jpg", "Aqui temos o review do filme com um texto legal e tal na sua sessão da tarde")

        val fakeMovies: MutableList<Movie> = mutableListOf(a, b, c, d)


        return fakeMovies
    }
}