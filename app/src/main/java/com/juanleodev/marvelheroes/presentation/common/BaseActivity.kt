package com.juanleodev.marvelheroes.presentation.common

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.domain.error.ErrorEntity

open class BaseActivity : AppCompatActivity() {

    private fun mapError(error: ErrorEntity): String {
        return when(error) {
            ErrorEntity.Network -> getString(R.string.error_network)
            ErrorEntity.NotFound -> getString(R.string.error_not_found)
            ErrorEntity.ServiceUnavailable -> getString(R.string.error_service_unavailable)
            ErrorEntity.Unknown -> getString(R.string.error_unknown)
            else -> error.message ?: getString(R.string.error_unknown)
        }
    }

    protected fun observeStatus(viewModel: BaseViewModel, parent: View) {
        viewModel.getLoadingObservable().observe(this, {
            LoadingDialog.show(this, it)
        })

        viewModel.getErrorObservable().observe(this, {
            SnackbarHelper.showSnackbar(
                this,
                parent,
                mapError(it),
                SnackbarHelper.Type.ERROR,
                R.string.ok
            )
        })
    }

}