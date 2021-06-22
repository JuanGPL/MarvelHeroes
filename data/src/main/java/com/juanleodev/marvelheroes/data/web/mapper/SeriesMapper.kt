package com.juanleodev.marvelheroes.data.web.mapper

import com.juanleodev.marvelheroes.data.web.model.serie.SeriesDataWrapper
import com.juanleodev.marvelheroes.domain.model.Serie

class SeriesMapper {

    companion object {
        fun mapToSeries(response: SeriesDataWrapper): List<Serie> {
            val serieList: ArrayList<Serie> = ArrayList()

            response.data?.result?.forEach {
                with(it) {
                    if (!title.isNullOrEmpty()) {
                        val serie = Serie(title)
                        serieList.add(serie)
                    }
                }
            }

            return serieList
        }
    }

}