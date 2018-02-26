package com.example.gabrielrosa.findmovie.application.moviedetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielrosa.findmovie.R
import com.example.gabrielrosa.findmovie.application.common.injection.InjectionUseCase
import com.example.gabrielrosa.findmovie.application.common.utils.BuildImageUrl
import com.example.gabrielrosa.findmovie.infrastructure.model.MovieDetailResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_detail_fragment.*

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

        mPresenter?.loadMovie(movieId!!)
    }

    override fun showMovie(movie: MovieDetailResponse) {

        movieDetailDescription.text = movie.overview
        movieDetailTitle.text       = movie.originalTitle

        Picasso.with(context)
                .load(BuildImageUrl.build(movie.backdropPath))
                .placeholder(R.drawable.shape_image_place_holder)
                .into(movieDetailImage)
    }

    override fun showError() {

    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

}