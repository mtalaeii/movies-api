package com.mtalaeii.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mtalaeii.search.R
import com.mtalaeii.search.databinding.LoadStateBinding

class MoviesLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<MoviesLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

        val progress = holder.binding.loadStateProgress
        val btnRetry = holder.binding.loadStateRetry
        val txtErrorMessage = holder.binding.loadStateErrorMessage

        btnRetry.isVisible = loadState !is LoadState.Loading
        txtErrorMessage.isVisible = loadState !is LoadState.Loading
        progress.isVisible = loadState is LoadState.Loading

        if (loadState is LoadState.Error){
            txtErrorMessage.text = loadState.error.localizedMessage
        }

        btnRetry.setOnClickListener {
            retry.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.load_state,parent,false)
        )
    }

    class LoadStateViewHolder(var binding: LoadStateBinding) : RecyclerView.ViewHolder(binding.root)
}