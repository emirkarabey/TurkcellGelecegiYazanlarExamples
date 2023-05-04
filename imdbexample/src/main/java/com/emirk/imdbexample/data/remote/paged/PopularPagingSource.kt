package com.emirk.imdbexample.data.remote.paged

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.emirk.imdbexample.data.remote.ApiService
import com.emirk.imdbexample.data.remote.model.Movie

class PopularMoviesPagingSource(
    private val apiService: ApiService
) :
    PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val movieUiModel =
                apiService.getPopularMovies(page).movies
            LoadResult.Page(
                data = movieUiModel,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (movieUiModel.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

}