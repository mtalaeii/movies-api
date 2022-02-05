package com.mtalaeii.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mtalaeii.search.databinding.SearchItemBinding
import com.mtalaeii.search.model.Data
import javax.inject.Inject

class MoviesAdapter @Inject constructor(): PagingDataAdapter<Data, MoviesAdapter.PassengersViewHolder>(PassengersComparator) {
    lateinit var onItemClick: OnItemClick
    inner class PassengersViewHolder(private val binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindMovies(item: Data) = with(binding) {
            Glide.with(binding.root).load(item.poster).into(binding.image)
            titleTxt.text = item.title
            genreTxt.text = "Genre :"+item.genres[0]
        }
    }

    override fun onBindViewHolder(holder: PassengersViewHolder, position: Int) {
        val item = getItem(position)
        item.let {
            if (it != null) {
                holder.bindMovies(it)
            }
        }
        holder.itemView.setOnClickListener {
            onItemClick.onClick(item!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassengersViewHolder {
        return PassengersViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    object PassengersComparator : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    fun setUpListener(onItemClick: OnItemClick){
        this.onItemClick = onItemClick
    }
}