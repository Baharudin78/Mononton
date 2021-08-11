package com.baharudin.mononton.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.mononton.databinding.ItemSomeTopRatedBinding
import com.baharudin.mononton.model.toprated.TopRated
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class TopRatedAdapter :
    PagingDataAdapter<TopRated, TopRatedAdapter.TopRatedHolder>(TOP_RATED_COMPARATOR) {
    override fun onBindViewHolder(holder: TopRatedHolder, position: Int) {
        val curentItem = getItem(position)
        if (curentItem != null) {
            holder.bindItem(curentItem)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopRatedHolder {
        val inflater = ItemSomeTopRatedBinding
            .inflate(LayoutInflater.from(
                parent.context
            ))
        return TopRatedHolder(inflater)
    }

    class TopRatedHolder(
        private val binding : ItemSomeTopRatedBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun bindItem(movie : TopRated) {
                binding.apply {
                    Glide.with(itemView)
                        .load("${movie.baseUrl} ${movie.poster_path}")
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ivToprated)
                    tvJudul.text = movie.original_title
                    ratingBar.rating = movie.vote_average.toFloat()
                }
            }

    }
    companion object {
        private val TOP_RATED_COMPARATOR = object : DiffUtil.ItemCallback<TopRated>() {
            override fun areItemsTheSame(oldItem: TopRated, newItem: TopRated): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TopRated, newItem: TopRated): Boolean {
                return oldItem == newItem
            }

        }
    }
}