package com.example.gabrielrosa.findmovie.application.moviedetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielrosa.findmovie.R

/**
 * Created by gabrielrosa on 25/02/18.
 */
class MovieDetailFragment: Fragment(), MovieDetailContract.View {

    private var movieId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieId = activity.intent.extras.get(MovieDetailActivity.MOVIE_ID) as Int?
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.movie_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}