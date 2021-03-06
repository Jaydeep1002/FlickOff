package bapspatil.flickoff.utils

/*
 ** Created by Bapusaheb Patil {@link https://bapspatil.com}
 */

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import bapspatil.flickoff.R
import bapspatil.flickoff.ui.details.CastRecyclerViewAdapter
import bapspatil.flickoff.model.Cast
import bapspatil.flickoff.model.Movie
import bapspatil.flickoff.network.TmdbApi
import bapspatil.flickoff.ui.main.MovieRecyclerViewAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import java.util.*

object BindingUtils {

    @BindingAdapter("adapter")
    @JvmStatic
    fun addCastItems(recyclerView: RecyclerView, casts: ArrayList<Cast>) {
        val adapter: CastRecyclerViewAdapter? = recyclerView.adapter as CastRecyclerViewAdapter?
        adapter?.clearItems()
        adapter?.addItems(casts)
    }

    @BindingAdapter("adapter")
    @JvmStatic
    fun addMovieItems(recyclerView: RecyclerView, movies: ArrayList<Movie>) {
        val adapter: MovieRecyclerViewAdapter? = recyclerView.adapter as MovieRecyclerViewAdapter?
        adapter?.clearItems()
        adapter?.addItems(movies)
    }

    @BindingAdapter("poster")
    @JvmStatic
    fun setMoviePoster(imageView: ImageView, posterPath: String) {
        GlideApp.with(imageView.context)
                .load(TmdbApi.POSTER_BASE_URL + posterPath)
                .error(R.drawable.tmdb_placeholder)
                .fallback(R.drawable.tmdb_placeholder)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }
} // Not publicly instantiable
