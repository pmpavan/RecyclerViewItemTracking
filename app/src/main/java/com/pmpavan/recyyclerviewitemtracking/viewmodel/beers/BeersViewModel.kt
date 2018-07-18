package com.pmpavan.recyyclerviewitemtracking.viewmodel.beers

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.BeerInteractor
import com.pmpavan.recyyclerviewitemtracking.domain.beers.model.BeerItem
import com.pmpavan.recyyclerviewitemtracking.viewmodel.base.BaseViewModel
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.events.ListLoadedEvent
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListItemUiState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class BeersViewModel @Inject constructor(var context: Context, var eventBus: EventBus, val interactor: BeerInteractor)
    : BaseViewModel(), BeerListItemUiState.BeerItemClickHandler {

    override fun onItemClick(position: Int, model: BeerListItemUiState) {

    }

    val data = MutableLiveData<MutableList<BeerListItemUiState>>()
    private val items = mutableListOf<BeerListItemUiState>()

    init {
        // subtypes --> airing, upcoming, tv, movie, ova, special
        interactor.getBeersListFromApi("anime", 1, "airing")
                .toObservable()
                .map { t -> t.getTop() ?: mutableListOf() }
                .concatMapIterable { t -> t }
                .concatMap { t ->
                    val uiState = BeerListItemUiState()
                    uiState.id = t.getMalId()!!
                    uiState.name = t.getTitle()
                    uiState.avatarUrl = t.getImageUrl()
                    return@concatMap Observable.just(uiState)
                }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    populateListView(it)
                }, {
                    Log.e("BeersViewModel", it.toString())
                })
    }

    private fun populateListView(it: MutableList<BeerListItemUiState>) {
//        Log.i("BeersViewModel", it.toString())
        items.clear()
        items.addAll(it)
        data.postValue(items)
        eventBus.post(ListLoadedEvent())
    }
}