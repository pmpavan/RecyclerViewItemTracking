package com.pmpavan.recyyclerviewitemtracking.data.beers

import com.pmpavan.recyyclerviewitemtracking.data.base.BaseApi
import com.pmpavan.recyyclerviewitemtracking.domain.beers.model.BeerItem
import io.reactivex.Single
import javax.inject.Inject

class BeerApi @Inject constructor(val apiInterface: BeerApiService) : BaseApi() {

    fun getBeersListFromApi(): Single<List<BeerItem>> {
        return apiInterface.getBeersList()
    }

}