package com.techmashinani.filamu.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.techmashinani.filamu.R
import com.techmashinani.filamu.di.Injectable
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.ui.adapters.LatestMoviesAdapter
import com.techmashinani.filamu.utils.toast
import com.techmashinani.filamu.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

    @Inject lateinit var mFactory: ViewModelProvider.Factory
    val latestAdapter: LatestMoviesAdapter by lazy { LatestMoviesAdapter {movie -> actOnMovie(movie)} }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, mFactory).get(MainViewModel::class.java)
        loadLatestMovies()

        recycler_latest_movie.apply {
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        }
    }

    private fun actOnMovie(movie: Movie) {
        "${movie.overview} is Movie no ${movie.id}".toast(activity!!.applicationContext)
    }

    private fun loadLatestMovies() {
        viewModel.getUpcomingMovies()
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this, Observer { loading ->
                if(loading) {

                } else {

                }
        })
    }
}
