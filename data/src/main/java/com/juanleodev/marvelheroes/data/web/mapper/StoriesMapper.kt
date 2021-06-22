package com.juanleodev.marvelheroes.data.web.mapper

import com.juanleodev.marvelheroes.data.web.model.story.StoryDataWrapper
import com.juanleodev.marvelheroes.domain.model.Story

class StoriesMapper {

    companion object {
        fun mapToStories(response: StoryDataWrapper): List<Story> {
            val storyList: ArrayList<Story> = ArrayList()

            response.data?.result?.forEach {
                with(it) {
                    if (!title.isNullOrEmpty()) {
                        val story = Story(title)
                        storyList.add(story)
                    }
                }
            }

            return storyList
        }
    }

}