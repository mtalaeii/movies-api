package com.mtalaeii.favorites.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mtalaeii.core.model.Data
import com.mtalaeii.favorites.databinding.FavoriteItemBinding
import javax.inject.Inject

class RvAdapter @Inject constructor() : RecyclerView.Adapter<RvAdapter.RvViewHolder>(){
    lateinit var onItemClick:OnItemClick
    lateinit var data:List<Data>
    inner class RvViewHolder(var binding:FavoriteItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(item:Data){
            binding.imdbTxt.text = item.imdb_rating.toString()
            binding.titleTxt.text = item.title
            Glide.with(binding.root).load(item.poster).into(binding.image)
        }
    }

    fun setData1(data:List<Data>){
        this.data = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(
            FavoriteItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bindData(data[position])
        holder.binding.deleteItem.setOnClickListener {
            onItemClick.onClick(data[position])
        }
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}