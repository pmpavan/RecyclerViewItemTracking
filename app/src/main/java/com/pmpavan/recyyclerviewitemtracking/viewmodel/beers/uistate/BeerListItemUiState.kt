package com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate

import android.text.Html

class BeerListItemUiState {
    interface BeerItemClickHandler {
        fun onItemClick(position: Int, model: BeerListItemUiState)
    }

    var id: Long = -1L
    var name: String? = ""
        set(value) {
            field = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                Html.fromHtml(value).toString()
            }
        }
    var avatarUrl: String? = null
    var handler: BeerItemClickHandler? = null

    override fun toString(): String {
        return "BeerListItemUiState(id=$id, name=$name, avatarUrl=$avatarUrl, handler=$handler)"
    }


}