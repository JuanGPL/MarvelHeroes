package com.juanleodev.marvelheroes.presentation.herodetail.mapper

import com.juanleodev.marvelheroes.domain.model.Hero
import com.juanleodev.marvelheroes.presentation.herodetail.model.HeroDetail

class HeroDetailMapper {

    operator fun invoke(hero: Hero): HeroDetail {
        return HeroDetail(hero.id!!, hero.name!!, hero.description!!, hero.image!!)
    }

}