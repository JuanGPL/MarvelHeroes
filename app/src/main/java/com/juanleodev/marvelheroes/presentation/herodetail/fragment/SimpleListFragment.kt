package com.juanleodev.marvelheroes.presentation.herodetail.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.databinding.FragmentSimpleListBinding
import com.juanleodev.marvelheroes.presentation.herodetail.adapter.SimpleListAdapter

class SimpleListFragment(
    private val textList: List<String>?
) : Fragment(R.layout.fragment_simple_list) {

    private var binding: FragmentSimpleListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSimpleListBinding.bind(view)

        with(binding?.recyclerSimpleItems) {
            this?.layoutManager = LinearLayoutManager(requireContext())
            this?.adapter = SimpleListAdapter(textList ?: ArrayList())
        }
    }

//    private fun setRecyclerViewScrollListener() {
//        with(binding?.recyclerSimpleItems) {
//            addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//                    if ((layoutManager as LinearLayoutManager).findLastVisibleItemPosition() == (adapter as SimpleListAdapter).itemCount - 1) {
//                        viewModel.getHeroesList()
//                        removeOnScrollListener(this)
//                    }
//                }
//            })
//        }
//    }

}