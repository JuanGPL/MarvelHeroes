package com.juanleodev.marvelheroes.presentation.herodetail.fragment.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.usecase.GetComics
import com.juanleodev.marvelheroes.presentation.common.BaseViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.comics.mapper.ComicListMapper
import kotlinx.coroutines.launch

class ComicsViewModel(
    private val getComics: GetComics,
    private val mapper: ComicListMapper
) : BaseViewModel() {

    private val comicsListCached: ArrayList<String> = ArrayList()
    private val comicsListLiveData = MutableLiveData<List<String>>()
    fun getComicListObservable(): LiveData<List<String>> = comicsListLiveData

    fun getComicList(heroId: Int) {
        showLoading(true)
        viewModelScope.launch {
            when (val comicsListResult = getComics(heroId, comicsListCached.size)) {
                is Resource.Success -> {
                    val comicList = mapper(comicsListResult.data)
                    comicsListCached.addAll(comicList)
                    comicsListLiveData.postValue(comicsListCached)
                    showLoading(false)
                }

                is Resource.Error -> {
                    showError(comicsListResult.error)
                }
            }
        }
    }

}