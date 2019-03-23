package com.techmashinani.filamu.ui.adapters.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techmashinani.filamu.model.Movie

class MovieViewHolder private constructor(private val view: View, private val listener: (Movie) -> Unit) : RecyclerView.ViewHolder(view) {

    fun initView(movie: Movie) {

    }

    companion object {
        @JvmStatic fun create(parent: ViewGroup, resource: Int, listener: (Movie) -> Unit): MovieViewHolder =
            MovieViewHolder(LayoutInflater.from(parent.context).inflate(resource,parent, false), listener)
    }
}