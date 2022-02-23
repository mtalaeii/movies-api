package com.mtalaeii.search.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mtalaeii.core.base.BaseFragment
import com.mtalaeii.search.R
import com.mtalaeii.search.adapter.MoviesLoadStateAdapter
import com.mtalaeii.search.databinding.SearchFragmentBinding
import com.mtalaeii.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchFragment  : BaseFragment<SearchFragmentBinding>(SearchFragmentBinding::inflate) {
    private val viewModel:SearchViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(context)
        var scrollDy = 0
        mBinding.viewModel = viewModel
        setHasOptionsMenu(true)
        viewModel.starter()
        mBinding.searchRcv.apply {
            this.layoutManager = layoutManager
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    scrollDy += dy
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if(newState == RecyclerView.SCROLL_STATE_IDLE && scrollDy > 0)
                        mBinding.jumpUpFab.show()
                    else
                        mBinding.jumpUpFab.hide()
                    super.onScrollStateChanged(recyclerView, newState)
                }
            })
        }
        mBinding.jumpUpFab.setOnClickListener{
            layoutManager.scrollToPosition(0)
            mBinding.jumpUpFab.hide()
            scrollDy = 0
        }
        lifecycleScope.launch {
            viewModel.movies.collectLatest { pagedData ->
                viewModel.adapter.submitData(pagedData)
//                mBinding.progress.visibility = View.GONE

            }
        }
        lifecycleScope.launchWhenStarted {
            val a = async { viewModel.errorMsgFlow.collect {
                Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
            }}
            val b = async { viewModel.errorTypeFlow.collect {
                Toast.makeText(requireContext(), "Type: $it", Toast.LENGTH_SHORT).show()
            }}
            val d = async { viewModel.infoFlow.collect {
                findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToInfoFragment(it.id))
            }}
            a.await()
            b.await()
            d.await()

        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.actionSearch)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
//                mBinding.progress.visibility = View.VISIBLE
                lifecycleScope.launch {
                    viewModel.getByName(newText).collectLatest {
                        viewModel.adapter.submitData(it)
                        viewModel.adapter.notifyDataSetChanged()
//                        mBinding.progress.visibility = View.GONE
                    }
                }
                return false
            }
        })
    }


}


