package com.juanleodev.marvelheroes.presentation.herodetail.fragment.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.usecase.GetSeries
import com.juanleodev.marvelheroes.presentation.common.BaseViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.series.mapper.SerieListMapper
import kotlinx.coroutines.launch

class SeriesViewModel(
    private val getSeries: GetSeries,
    private val mapper: SerieListMapper
) : BaseViewModel() {

    private val seriesListCached: ArrayList<String> = ArrayList()
    private val seriesListLiveData = MutableLiveData<List<String>>()
    fun getSeriesListObservable(): LiveData<List<String>> = seriesListLiveData

    fun getSeriesList(heroId: Int) {
        showLoading(true)
        viewModelScope.launch {
            when (val seriesListResult = getSeries(heroId, seriesListCached.size)) {
                is Resource.Success -> {
                    val seriesList = mapper(seriesListResult.data)
                    seriesListCached.addAll(seriesList)
                    seriesListLiveData.postValue(seriesListCached)
                    showLoading(false)
                }

                is Resource.Error -> {
                    showError(seriesListResult.error)
                }
            }
        }
    }

}