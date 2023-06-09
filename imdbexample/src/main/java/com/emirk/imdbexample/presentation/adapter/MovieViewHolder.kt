package com.emirk.imdbexample.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emirk.imdbexample.data.remote.model.Movie
import com.emirk.imdbexample.data.remote.util.ApiConstants
import com.emirk.imdbexample.databinding.ItemMovieBinding

class MoviesViewHolder(
    private val binding: ItemMovieBinding,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        movie: Movie,
    ) = binding.apply {
        tvTitle.text = movie.title
        tvReleaseDate.text = movie.release_date
        Glide.with(ivMovie).load(ApiConstants.getPosterPath(movie.poster_path)).into(ivMovie)
    }
}