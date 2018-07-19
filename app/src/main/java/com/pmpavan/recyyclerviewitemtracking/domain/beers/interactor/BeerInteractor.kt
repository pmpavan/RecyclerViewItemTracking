package com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor

import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.AnimeItem
import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.Top
import io.reactivex.Single

interface BeerInteractor {

    fun getBeersListFromApi(type: String?, page: Int, subtype: String?): Single<List<Top>>

}