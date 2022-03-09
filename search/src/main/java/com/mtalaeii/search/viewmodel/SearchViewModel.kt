package com.mtalaeii.search.viewmodel
import android.util.Log
import com.mtalaeii.search.BR
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.recyclerview.widget.RecyclerView
import com.mtalaeii.core.base.BaseViewModel
import com.mtalaeii.core.base.Event
import com.mtalaeii.core.database.MoviesDao
import com.mtalaeii.core.repositories.DefaultMovieRepository
import com.mtalaeii.search.model.Data
import com.mtalaeii.core.request.ErrorType
import com.mtalaeii.core.request.RemoteErrorEmitter
import com.mtalaeii.search.R
import com.mtalaeii.search.adapter.MoviesAdapter
import com.mtalaeii.search.adapter.MoviesLoadStateAdapter
import com.mtalaeii.search.adapter.OnItemClick
import com.mtalaeii.search.request.MoviesDataSource
import com.mtalaeii.search.request.Repository
import com.mtalaeii.search.request.SearchDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(var repo: Repository, var adapter: MoviesAdapter,var movieRepo: DefaultMovieRepository): BaseViewModel(),
    RemoteErrorEmitter,OnItemClick {
    var errorTypeCh = Channel<String>()
    var errorMsg = Channel<String>()
    val errorTypeFlow = errorTypeCh.receiveAsFlow()
    var errorMsgFlow = errorMsg.receiveAsFlow()
    private val info = Channel<Data>()
    var infoFlow = info.receiveAsFlow()
    companion object{
        @JvmStatic
        @BindingAdapter(value = ["setAdapter"])
        fun RecyclerView.bindRVAdapter(viewModel: ViewModel){
            val myViewModel = viewModel as SearchViewModel
            this.adapter = myViewModel.adapter.withLoadStateFooter(MoviesLoadStateAdapter{
                myViewModel.adapter.retry()
            })
            this.setHasFixedSize(true)
        }
    }
    val movies =
        Pager(config = PagingConfig(pageSize = 10, prefetchDistance = 2), pagingSourceFactory = {
            MoviesDataSource(repo)
        }).flow.cachedIn(viewModelScope)
    fun getByName(name:String): Flow<PagingData<Data>> {
        return Pager(config = PagingConfig(pageSize = 10, prefetchDistance = 2), pagingSourceFactory = {
            SearchDataSource(repo,name)
        }).flow.cachedIn(viewModelScope)
    }
    fun starter() {
        repo.addEmitter(this)
        adapter.setUpListener(this)
//        adapter.setUpViewModel(this)
    }

    override fun onError(msg: String) {
        viewModelScope.launch {
            errorMsg.send(msg)
        }
    }

    override fun onError(errorType: ErrorType) {
        viewModelScope.launch {
            errorTypeCh.send(errorType.toString())
        }
    }

    override fun onClick(data: Data) {
        viewModelScope.launch {
            info.send(data)
        }
    }

    override fun onFavoriteIconCLick(data: Data) {
        viewModelScope.launch {
            movieRepo.insertMovieItem(
                com.mtalaeii.core.model.Data(
                    itemId = data.id,
                    id = data.id,
                    title = data.title,
                    poster = data.poster,
                    imdb_rating = data.imdb_rating
                )
            )
        }
    }

}