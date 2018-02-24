package com.example.gabrielrosa.findmovie.application.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.home_movie_item.view.*

/**
 * Created by gabrielrosa on 24/02/18.
 */
class MovieItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var movieImage       = itemView?.movieImage
    var movieTitle       = itemView?.movieTitle
    var movieDescription = itemView?.movieDescription
    var shareButton      = itemView?.shareButton
    var detailButton     = itemView?.detailButton
}