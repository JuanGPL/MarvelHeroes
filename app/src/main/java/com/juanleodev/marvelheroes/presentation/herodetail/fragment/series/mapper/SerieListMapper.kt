package com.juanleodev.marvelheroes.presentation.herodetail.fragment.series.mapper

import com.juanleodev.marvelheroes.domain.model.Serie

class SerieListMapper {

    operator fun invoke(serieList: List<Serie>): List<String> {
        return serieList.map { it.name.toString() }
    }

}