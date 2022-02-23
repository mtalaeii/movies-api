package com.mtalaeii.favorites.view
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mtalaeii.core.base.BaseFragment
import com.mtalaeii.favorites.databinding.FavoriteFragmentBinding
import com.mtalaeii.favorites.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FavoriteFragmentBinding>(FavoriteFragmentBinding::inflate) {
    private val viewModel: FavoriteViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
        val layoutManager = LinearLayoutManager(context)
        viewModel.itemList.observe(viewLifecycleOwner) {
            viewModel.adapter.setData1(it)
            mBinding.listHandler.apply {
                this.layoutManager = layoutManager
                adapter = viewModel.adapter
                setHasFixedSize(true)
                viewModel.adapter.onItemClick = viewModel
                ItemTouchHelper(viewModel.itemTouchCallBack).attachToRecyclerView(this)
            }
        }
        lifecycleScope.launch {
            viewModel.itemId.receiveAsFlow().collect {
                findNavController().navigate(Uri.parse("to://info/$it"))
            }
        }
        lifecycleScope.launch {
            viewModel.onDeleteItem.receiveAsFlow().collect { data->
                Snackbar.make(requireView(),"Successfully delete item", Snackbar.LENGTH_LONG).apply {
                    setAction("Undo"){
                        lifecycleScope.launch {
                            viewModel.movieRepo.insertMovieItem(data)
                        }
                    }
                    show()
                }
            }
        }


    }
}