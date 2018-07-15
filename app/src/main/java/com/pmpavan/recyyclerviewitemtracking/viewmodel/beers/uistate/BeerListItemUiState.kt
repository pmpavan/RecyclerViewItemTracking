package com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate

class BeerListItemUiState {
    interface BeerItemClickHandler {
        fun onItemClick(position: Int, model: BeerListItemUiState)
    }

    var id: Long = -1L
    var name: String? = ""
    var avatarUrl: String? = null
    var handler: BeerItemClickHandler? = null

}