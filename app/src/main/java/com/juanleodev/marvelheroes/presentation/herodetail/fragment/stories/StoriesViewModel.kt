package com.juanleodev.marvelheroes.presentation.herodetail.fragment.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juanleodev.marvelheroes.domain.Resource
import com.juanleodev.marvelheroes.domain.usecase.GetStories
import com.juanleodev.marvelheroes.presentation.common.BaseViewModel
import com.juanleodev.marvelheroes.presentation.herodetail.fragment.stories.mapper.StoryListMapper
import kotlinx.coroutines.launch

class StoriesViewModel(
    private val getStories: GetStories,
    private val mapper: StoryListMapper
) : BaseViewModel() {

    private val storiesListCached: ArrayList<String> = ArrayList()
    private val storiesListLiveData = MutableLiveData<List<String>>()
    fun getStoryListObservable(): LiveData<List<String>> = storiesListLiveData

    fun getStoryList(heroId: Int) {
        showLoading(true)
        viewModelScope.launch {
            when (val storiesListResult = getStories(heroId, storiesListCached.size)) {
                is Resource.Success -> {
                    val storyList = mapper(storiesListResult.data)
                    storiesListCached.addAll(storyList)
                    storiesListLiveData.postValue(storiesListCached)
                    showLoading(false)
                }

                is Resource.Error -> {
                    showError(storiesListResult.error)
                }
            }
        }
    }
}