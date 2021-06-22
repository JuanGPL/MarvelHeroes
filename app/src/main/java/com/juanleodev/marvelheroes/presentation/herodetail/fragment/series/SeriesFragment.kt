package com.juanleodev.marvelheroes.presentation.herodetail.fragment.series

import android.os.Bundle
import android.view.View
import com.juanleodev.marvelheroes.databinding.FragmentSeriesBinding
import com.juanleodev.marvelheroes.presentation.herodetail.adapter.SimpleListAdapter
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.SimpleListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeriesFragment(private val heroId: Int?) : SimpleListFragment() {

    private var binding: FragmentSeriesBinding? = null

    private val viewModel by viewModel<SeriesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSeriesBinding.bind(view)

        initRecyclerView(binding?.recyclerSimpleItems)
        observeStatus()

        viewModel.getSeriesList(heroId ?: -1)
    }

    private fun observeStatus() {
        super.observeStatus(viewModel, binding?.root as View)

        viewModel.getSeriesListObservable().observe(viewLifecycleOwner, {
            (binding?.recyclerSimpleItems?.adapter as SimpleListAdapter).setItems(it)
        })
    }

}