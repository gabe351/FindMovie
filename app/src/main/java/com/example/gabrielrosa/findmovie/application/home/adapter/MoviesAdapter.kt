package com.example.gabrielrosa.findmovie.application.home.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gabrielrosa.findmovie.R
import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.example.gabrielrosa.findmovie.application.moviedetail.MovieDetailActivity
import com.squareup.picasso.Picasso

/**
 * Created by gabrielrosa on 24/02/18.
 */
class MoviesAdapter(): RecyclerView.Adapter<MovieItemViewHolder>() {

    var movies = listOf<Movie>()
    private lateinit var context: Context

    private var inflater: LayoutInflater? = null

    constructor(context: Context, movies: List<Movie>) : this() {
        inflater     = LayoutInflater.from(context)
        this.movies  = movies
        this.context = context
    }

    fun replaceData(list: List<Movie>) {
        movies = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder?, position: Int) {
        val movie = movies.get(position)

        holder?.movieTitle?.text       = movie.originalTitle
        holder?.movieDescription?.text = movie.overview

        Picasso.with(context)
                .load(buildImageUrl(movie.backdropPath))
                .placeholder(R.drawable.shape_image_place_holder)
                .into(holder?.movieImage)

        holder?.detailButton?.setOnClickListener {
                val intent = Intent(context, MovieDetailActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(MovieDetailActivity.MOVIE_ID, movie?.id)
                intent.putExtras(bundle)
                startActivity(context, intent,null)
        }

//        TODO: Implement click on buttons
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieItemViewHolder {
        val view = inflater?.inflate(R.layout.home_movie_item, parent, false)
        return MovieItemViewHolder(view)
    }


    private fun buildImageUrl(path: String): String {
        val imageBaseUrl: String = "https://image.tmdb.org/t/p/w780"
        val stringBuilder = StringBuilder()

        stringBuilder.append(imageBaseUrl).append(path)

        return stringBuilder.toString()
    }
}