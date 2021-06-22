package com.juanleodev.marvelheroes.presentation.herodetail.fragment.stories.mapper

import com.juanleodev.marvelheroes.domain.model.Story

class StoryListMapper {

    operator fun invoke(storyList: List<Story>): List<String> {
        return storyList.map { it.name.toString() }
    }

}