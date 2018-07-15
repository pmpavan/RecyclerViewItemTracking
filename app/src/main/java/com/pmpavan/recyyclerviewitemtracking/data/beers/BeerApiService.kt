package com.pmpavan.recyyclerviewitemtracking.data.beers

import com.pmpavan.recyyclerviewitemtracking.domain.beers.model.BeerItem
import io.reactivex.Single
import retrofit2.http.GET

interface BeerApiService {

    @GET("beers")
    fun getBeersList(): Single<List<BeerItem>>
}