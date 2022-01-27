package com.mtalaeii.search.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtalaeii.core.BaseFragment
import com.mtalaeii.search.R
import com.mtalaeii.search.databinding.SearchFragmentBinding
import com.mtalaeii.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchFragmentBinding>() {

    override fun getLayoutRes(): Int {
        return R.layout.search_fragment
    }

}