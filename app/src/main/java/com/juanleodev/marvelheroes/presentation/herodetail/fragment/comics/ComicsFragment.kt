package com.juanleodev.marvelheroes.presentation.herodetail.fragment.comics

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juanleodev.marvelheroes.databinding.FragmentComicsBinding
import com.juanleodev.marvelheroes.presentation.herodetail.adapter.SimpleListAdapter
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.SimpleListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicsFragment(private val heroId: Int?) : SimpleListFragment() {

    private var binding: FragmentComicsBinding? = null

    private val viewModel by viewModel<ComicsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentComicsBinding.bind(view)

        initRecyclerView(binding?.recyclerSimpleItems)
        observeStatus()

        viewModel.getComicList(heroId ?: -1)
    }

    private fun observeStatus() {
        super.observeStatus(viewModel, binding?.root as View)

        viewModel.getComicListObservable().observe(viewLifecycleOwner, {
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
                        viewModel.getComicList(heroId ?: -1)
                        removeOnScrollListener(this)
                    }
                }
            })
        }
    }
}