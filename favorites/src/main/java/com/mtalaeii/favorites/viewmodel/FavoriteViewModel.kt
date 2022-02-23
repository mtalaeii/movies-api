package com.mtalaeii.favorites.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mtalaeii.core.base.BaseViewModel
import com.mtalaeii.core.repositories.DefaultMovieRepository
import com.mtalaeii.core.model.Data
import com.mtalaeii.favorites.adapters.OnItemClick
import com.mtalaeii.favorites.adapters.RvAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    val movieRepo: DefaultMovieRepository,
    val adapter:RvAdapter
): BaseViewModel(),OnItemClick {
    val text = "test"
    val itemList = MutableLiveData<List<Data>>()
    val onDeleteItem = Channel<Data>()
    val itemId = Channel<Int>()
    fun getData(){
        movieRepo.observeAllMoviesItems().observeForever {
                itemList.postValue(it)
        }
    }
    val itemTouchCallBack = object : ItemTouchHelper.SimpleCallback(
        0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        )= true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val pos = viewHolder.layoutPosition
            val item = adapter.data[pos]
            viewModelScope.launch {
                movieRepo.deleteMovieItem(item)
                onDeleteItem.send(item)
            }
        }
    }
    override fun onClick(data: Data) {
        viewModelScope.launch {
            movieRepo.deleteMovieItem(data)
            onDeleteItem.send(data)
        }
    }

    override fun onItemClick(data: Data) {
        viewModelScope.launch {
            itemId.send(data.id)
        }
    }
}