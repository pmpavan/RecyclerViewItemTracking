package com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter

import android.support.v7.util.DiffUtil
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListItemUiState

val BeerDiffCallBack = object : DiffUtil.ItemCallback<BeerListItemUiState>() {
    override fun areItemsTheSame(oldItem: BeerListItemUiState, newItem: BeerListItemUiState): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: BeerListItemUiState, newItem: BeerListItemUiState): Boolean = oldItem == newItem
}