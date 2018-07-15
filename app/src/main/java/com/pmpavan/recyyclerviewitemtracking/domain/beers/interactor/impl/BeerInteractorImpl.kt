package com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.impl

import com.pmpavan.recyyclerviewitemtracking.data.beers.BeerApi
import com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.BeerInteractor
import com.pmpavan.recyyclerviewitemtracking.domain.beers.model.BeerItem
import io.reactivex.Single
import javax.inject.Inject

class BeerInteractorImpl @Inject constructor(val api: BeerApi) : BeerInteractor {
    override fun getBeersListFromApi(): Single<List<BeerItem>> {
        return api.getBeersListFromApi()
    }
}