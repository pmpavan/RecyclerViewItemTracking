package com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor

import android.arch.paging.DataSource
import android.arch.paging.ItemKeyedDataSource
import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.AnimeItem
import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.Top
import com.pmpavan.recyyclerviewitemtracking.domain.beers.model.Query

class BeerNetworkDataSource  constructor(
        val dataProvider: BeerInteractor) : ItemKeyedDataSource<Query, Top>() {
    override fun loadInitial(params: LoadInitialParams<Query>, callback: LoadInitialCallback<Top>) {
        dataProvider.getBeersListFromApi(params.requestedInitialKey?.query, params.requestedLoadSize, params.requestedInitialKey?.query)
                .subscribe({ users ->
                    callback.onResult(users)
                }, { throwable -> })
    }

    override fun loadAfter(params: LoadParams<Query>, callback: LoadCallback<Top>) {
        dataProvider.getBeersListFromApi(params.key?.query, params.requestedLoadSize, params.key?.query)
                .subscribe({ users ->
                    callback.onResult(users)
                }, { throwable -> })
    }

    override fun loadBefore(params: LoadParams<Query>, callback: LoadCallback<Top>) {
    }

    override fun getKey(item: Top): Query {
        return item.getMalId()
    }
}
