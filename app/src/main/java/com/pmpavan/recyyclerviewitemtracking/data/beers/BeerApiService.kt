package com.pmpavan.recyyclerviewitemtracking.data.beers

import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.AnimeItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerApiService {

    @GET("{type}/{page}/{subtype}")
    fun getBeersList(@Path("type") type: String?, @Path("page") page: Int, @Path("subtype") subtype: String?): Single<AnimeItem>
}