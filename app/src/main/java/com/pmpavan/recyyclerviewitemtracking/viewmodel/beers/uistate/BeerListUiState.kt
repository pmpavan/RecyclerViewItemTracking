package com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate

import android.databinding.ObservableArrayList
import javax.inject.Inject

class BeerListUiState @Inject constructor() {

    val items: ObservableArrayList<BeerListItemUiState> = ObservableArrayList()

    fun update(stateList: MutableList<BeerListItemUiState>) {
        items.clear()
        items.addAll(stateList)
    }
}