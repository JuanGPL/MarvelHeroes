package com.juanleodev.marvelheroes.presentation.herodetail.fragment.comics.mapper

import com.juanleodev.marvelheroes.domain.model.Comic

class ComicListMapper {

    operator fun invoke(comicList: List<Comic>): List<String> {
        return comicList.map { it.name.toString() }
    }

}