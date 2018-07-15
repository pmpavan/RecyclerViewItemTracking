package com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor

import com.pmpavan.recyyclerviewitemtracking.domain.beers.model.BeerItem
import io.reactivex.Single

interface BeerInteractor {

    fun getBeersListFromApi(): Single<List<BeerItem>>

}