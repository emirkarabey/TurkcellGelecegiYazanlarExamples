package com.emirk.imdbexample.domain.repository

import androidx.paging.PagingData
import com.emirk.imdbexample.data.remote.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(coroutineScope: CoroutineScope): Flow<PagingData<Movie>>
}