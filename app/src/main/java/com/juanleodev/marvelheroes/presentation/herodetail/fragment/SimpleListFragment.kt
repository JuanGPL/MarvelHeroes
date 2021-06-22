package com.juanleodev.marvelheroes.presentation.herodetail.fragment

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.domain.error.ErrorEntity
import com.juanleodev.marvelheroes.presentation.common.BaseViewModel
import com.juanleodev.marvelheroes.presentation.common.LoadingDialog
import com.juanleodev.marvelheroes.presentation.common.SnackbarHelper
import com.juanleodev.marvelheroes.presentation.herodetail.adapter.SimpleListAdapter

open class SimpleListFragment : Fragment(R.layout.fragment_simple_list) {

    private fun mapError(error: ErrorEntity): String {
        return when (error) {
            ErrorEntity.Network -> getString(R.string.error_network)
            ErrorEntity.NotFound -> getString(R.string.error_not_found)
            ErrorEntity.ServiceUnavailable -> getString(R.string.error_service_unavailable)
            ErrorEntity.Unknown -> getString(R.string.error_unknown)
            else -> error.message ?: getString(R.string.error_unknown)
        }
    }

    protected fun initRecyclerView(recycler: RecyclerView?) {
        recycler?.layoutManager = LinearLayoutManager(requireContext())
        recycler?.adapter = SimpleListAdapter()
    }

    protected fun observeStatus(viewModel: BaseViewModel, parent: View) {
        viewModel.getLoadingObservable().observe(this, {
            LoadingDialog.show(requireContext(), it)
        })

        viewModel.getErrorObservable().observe(viewLifecycleOwner, {
            SnackbarHelper.showSnackbar(
                requireContext(),
                parent,
                mapError(it),
                SnackbarHelper.Type.ERROR,
                R.string.ok
            )
        })
    }

    protected fun toogleNoResults(tvNoResults: TextView?, result: List<String>) {
        tvNoResults?.visibility = if (result.isEmpty()) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

}