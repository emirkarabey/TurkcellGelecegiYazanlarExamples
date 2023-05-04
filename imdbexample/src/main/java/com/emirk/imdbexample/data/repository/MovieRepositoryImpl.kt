package com.emirk.imdbexample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.emirk.imdbexample.data.remote.ApiService
import com.emirk.imdbexample.data.remote.model.Movie
import com.emirk.imdbexample.data.remote.paged.PopularMoviesPagingSource
import com.emirk.imdbexample.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {
    override fun getPopularMovies(coroutineScope: CoroutineScope): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = { PopularMoviesPagingSource(apiService) }
        ).flow.cachedIn(coroutineScope)
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 10
    }
}