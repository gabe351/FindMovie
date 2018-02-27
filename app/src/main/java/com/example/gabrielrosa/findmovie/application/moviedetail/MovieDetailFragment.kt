package com.example.gabrielrosa.findmovie.application.moviedetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gabrielrosa.findmovie.R
import com.example.gabrielrosa.findmovie.application.common.injection.InjectionUseCase
import com.example.gabrielrosa.findmovie.infrastructure.model.MovieDetailResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.home_movie_item.view.*
import kotlinx.android.synthetic.main.movie_detail_fragment.*
import java.util.*

/**
 * Created by gabrielrosa on 25/02/18.
 */
class MovieDetailFragment: Fragment(), MovieDetailContract.View {

    private var movieId: Int? = null
    private var mPresenter: MovieDetailContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieId    = activity.intent.extras.get(MovieDetailActivity.MOVIE_ID) as Int?
        mPresenter = MovieDetailPresenter(this, InjectionUseCase.provideGetMovieDetail())
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.movie_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieDetailCollapsingToolbar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
        mainToolbarSetup()
        mPresenter?.loadMovie(movieId!!)

    }

    override fun showMovie(movie: MovieDetailResponse) {

        val calendar = Calendar.getInstance()
        calendar.time = movie.releaseDate
        movieDetailReleaseDate.text = calendar.get(Calendar.YEAR).toString()
        movieDetailStatus.text      = movie.status

        if (movie.productionResponse.isNotEmpty()) {
            movieDetailProduction.text  = movie.productionResponse[0].name
        }

        movieDetailDescription.text = movie.overview

        Picasso.with(context)
                .load(build(movie.backdropPath))
                .placeholder(R.drawable.shape_image_place_holder)
                .into(movieDetailImage)

        movieDetailCollapsingToolbar.title = movie.originalTitle
    }

    override fun showError() {
        Toast.makeText(activity, resources.getString(R.string.error_message), Toast.LENGTH_LONG).show();
    }

    override fun showLoader() {
        moviesDetailLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        moviesDetailLoader.visibility = View.GONE
    }

    private fun build(path: String): String {
        val imageBaseUrl: String = "https://image.tmdb.org/t/p/w780"
        val stringBuilder = StringBuilder()

        stringBuilder.append(imageBaseUrl).append(path)

        return stringBuilder.toString()
    }

    private fun mainToolbarSetup() {
        if (movieDetailToolbar != null) {
            (activity as AppCompatActivity).setSupportActionBar(movieDetailToolbar)
            (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(false)
            (activity as AppCompatActivity).supportActionBar!!.setDisplayShowTitleEnabled(false)
            movieDetailToolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_white)
            movieDetailToolbar.setNavigationOnClickListener({ activity.onBackPressed() })
        }
    }

}