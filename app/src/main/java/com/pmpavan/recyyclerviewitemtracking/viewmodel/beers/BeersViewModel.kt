package com.pmpavan.recyyclerviewitemtracking.viewmodel.beers

import android.content.Context
import android.util.Log
import com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.BeerInteractor
import com.pmpavan.recyyclerviewitemtracking.viewmodel.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class BeersViewModel @Inject constructor(var context: Context, var eventBus: EventBus, val interactor: BeerInteractor)
    : BaseViewModel() {
    init {
        interactor.getBeersListFromApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.i("BeersViewModel", it.toString())
                }, {
                    Log.e("BeersViewModel", it.toString())
                })
    }
}