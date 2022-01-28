package com.mtalaeii.search.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.search.R
import com.mtalaeii.search.adapter.MoviesAdapter
import com.mtalaeii.search.databinding.SearchFragmentBinding
import com.mtalaeii.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchFragmentBinding>() {
    private val viewModel:SearchViewModel by viewModels()
    override fun getLayoutRes(): Int {
        (activity as AppCompatActivity).supportActionBar?.title = "Search"
        return R.layout.search_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter2 = MoviesAdapter()
        mBinding.searchRcv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter2
            setHasFixedSize(true)
        }
        lifecycleScope.launch {
            viewModel.movies.collectLatest { pagedData ->
                adapter2.submitData(pagedData)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

}