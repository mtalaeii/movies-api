package com.mtalaeii.search.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.search.R
import com.mtalaeii.search.adapter.MoviesAdapter
import com.mtalaeii.search.databinding.SearchFragmentBinding
import com.mtalaeii.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import okhttp3.RequestBody
import javax.inject.Inject


@AndroidEntryPoint
class SearchFragment  : BaseFragment<SearchFragmentBinding>() {
    private val viewModel:SearchViewModel by viewModels()
    override fun getLayoutRes(): Int {
        (activity as AppCompatActivity).supportActionBar?.title = "Search"
        return R.layout.search_fragment
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(context)
        var scrollDy = 0
        val bottomSheet = BottomSheetBehavior.from(mBinding.btmSh.root)
        viewModel.starter()
        mBinding.searchRcv.apply {
            this.layoutManager = layoutManager
            adapter = viewModel.adapter
            setHasFixedSize(true)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0 || dy < 0 && mBinding.addFab.isShown)
                        mBinding.addFab.hide()
                    scrollDy += dy
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE)
                        mBinding.addFab.show()
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
        mBinding.addFab.setOnClickListener{
            bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
        }
        mBinding.btmSh.btnInsert.setOnClickListener {
            when{
                mBinding.btmSh.edtTitle.text.isEmpty() -> mBinding.btmSh.edtTitle.error = "Required!"
                mBinding.btmSh.edtImdbId.text.isEmpty() -> mBinding.btmSh.edtImdbId.error = "Required!"
                mBinding.btmSh.edtCountry.text.isEmpty() -> mBinding.btmSh.edtCountry.error = "Required!"
                mBinding.btmSh.edtYear.text.isEmpty() -> mBinding.btmSh.edtYear.error = "Required!"
                else -> {
                    val map = HashMap<String,String>()
                    map["title"] = mBinding.btmSh.edtTitle.text.toString()
                    map["imdb_id"] = mBinding.btmSh.edtImdbId.text.toString()
                    map["country"] = mBinding.btmSh.edtCountry.text.toString()
                    map["year"] = mBinding.btmSh.edtYear.text.toString()
                    viewModel.insertMovie(map)
                }
            }
        }
        lifecycleScope.launch {
            viewModel.movies.collectLatest { pagedData ->
                viewModel.adapter.submitData(pagedData)
            }
        }
        lifecycleScope.launchWhenStarted {
            val a = async { viewModel.errorMsgFlow.collect {
                Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
            }}
            val b = async { viewModel.errorTypeFlow.collect {
                Toast.makeText(requireContext(), "Type: $it", Toast.LENGTH_SHORT).show()
            }}
            val c = async { viewModel.insertResponseF.collect {
                Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
            }}
            val d = async { viewModel.infoFlow.collect {
                findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToInfoFragment(it))
            }}
            a.await()
            b.await()
            c.await()
            d.await()

        }
        super.onViewCreated(view, savedInstanceState)
    }

}


