package com.juanleodev.marvelheroes.presentation.herodetail.fragment.stories

import android.os.Bundle
import android.view.View
import com.juanleodev.marvelheroes.databinding.FragmentStoriesBinding
import com.juanleodev.marvelheroes.presentation.herodetail.adapter.SimpleListAdapter
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.SimpleListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoriesFragment(private val heroId: Int?) : SimpleListFragment() {

    private var binding: FragmentStoriesBinding? = null

    private val viewModel by viewModel<StoriesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStoriesBinding.bind(view)

        initRecyclerView(binding?.recyclerSimpleItems)
        observeStatus()

        viewModel.getStoryList(heroId ?: -1)
    }

    private fun observeStatus() {
        super.observeStatus(viewModel, binding?.root as View)

        viewModel.getStoryListObservable().observe(viewLifecycleOwner, {
            (binding?.recyclerSimpleItems?.adapter as SimpleListAdapter).setItems(it)
        })
    }

}