package com.juanleodev.marvelheroes.data.web.mapper

import com.juanleodev.marvelheroes.data.web.model.comic.ComicDataWrapper
import com.juanleodev.marvelheroes.domain.model.Comic

class ComicsMapper {

    companion object {
        fun mapToComic(response: ComicDataWrapper): List<Comic> {
            val comicList: ArrayList<Comic> = ArrayList()

            response.data?.result?.forEach {
                with(it) {
                    if (!title.isNullOrEmpty()) {
                        val comic = Comic(title)
                        comicList.add(comic)
                    }
                }
            }

            return comicList
        }
    }

}