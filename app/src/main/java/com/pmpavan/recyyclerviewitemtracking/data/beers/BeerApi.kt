package com.pmpavan.recyyclerviewitemtracking.data.beers

import com.pmpavan.recyyclerviewitemtracking.data.base.BaseApi
import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.AnimeItem
import io.reactivex.Single
import javax.inject.Inject

class BeerApi @Inject constructor(val apiInterface: BeerApiService) : BaseApi() {

    fun getBeersListFromApi(type: String, page: Int, subtype: String): Single<AnimeItem> {
        return apiInterface.getBeersList(type, page, subtype)
    }

}