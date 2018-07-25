package com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor

import android.arch.paging.ItemKeyedDataSource
import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.Top

class BeerNetworkDataSource constructor(
        val dataProvider: BeerInteractor) : ItemKeyedDataSource<String, Top>() {


    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<Top>) {
        dataProvider.getBeersListFromApi(params.requestedInitialKey, params.requestedLoadSize, "airing")
                .subscribe({ users ->
                    callback.onResult(users)
                }, { throwable -> })
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<Top>) {
        dataProvider.getBeersListFromApi(params.key, params.requestedLoadSize, "airing")
                .subscribe({ users ->
                    callback.onResult(users)
                }, { throwable -> })
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<Top>) {
    }

    override fun getKey(item: Top): String {
        return item.getTitle()!!
    }
}
