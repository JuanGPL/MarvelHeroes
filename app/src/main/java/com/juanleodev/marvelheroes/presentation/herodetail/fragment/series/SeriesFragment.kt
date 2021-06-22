package com.juanleodev.marvelheroes.presentation.herodetail.fragment.series

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            toogleNoResults(binding?.tvNoResults, it)
            (binding?.recyclerSimpleItems?.adapter as SimpleListAdapter).setItems(it)
            setRecyclerViewScrollListener()
        })
    }

    private fun setRecyclerViewScrollListener() {
        with(binding?.recyclerSimpleItems) {
            this?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if ((layoutManager as LinearLayoutManager).findLastVisibleItemPosition() == (adapter as SimpleListAdapter).itemCount - 1) {
                        viewModel.getSeriesList(heroId ?: -1)
                        removeOnScrollListener(this)
                    }
                }
            })
        }
    }

}