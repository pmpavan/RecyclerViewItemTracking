package com.pmpavan.recyyclerviewitemtracking.viewmodel.beers

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.Top
import com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.BeerInteractor
import com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.BeerNetworkDataSource
import com.pmpavan.recyyclerviewitemtracking.domain.beers.model.Query
import javax.inject.Inject

class BeerDataSourceFactory @Inject constructor(private val githubService: BeerInteractor)
    : DataSource.Factory<Query, Top>() {

    val usersDataSourceLiveData = MutableLiveData<BeerNetworkDataSource>()

    override fun create(): DataSource<Query, Top> {
        val usersDataSource = BeerNetworkDataSource(githubService)
        usersDataSourceLiveData.postValue(usersDataSource)
        return usersDataSource
    }
}