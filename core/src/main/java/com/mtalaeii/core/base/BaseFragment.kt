package com.mtalaeii.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<DB : ViewBinding>(
    private val inflate: Inflate<DB>
) : Fragment() {
    private var _binding : DB? = null
    val mBinding :DB get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = inflate.invoke(inflater, container, false)
//        findNavController().apply {
//            addOnDestinationChangedListener {
//                    _, _, _ ->
//                if(activity != null)
//                    (requireActivity() as AppCompatActivity).supportActionBar?.title = this.currentDestination?.label
//            }
//        }
        return mBinding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
    open fun refresh() {}
}