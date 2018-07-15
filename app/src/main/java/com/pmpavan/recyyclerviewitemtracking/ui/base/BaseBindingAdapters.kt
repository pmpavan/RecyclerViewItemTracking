package com.pmpavan.recyyclerviewitemtracking.ui.base

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter.BeerListAdapter
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListItemUiState

object BaseBindingAdapters {

    @BindingAdapter("items")
    @JvmStatic
    fun RecyclerView.setAdapter(items: MutableList<BeerListItemUiState>?) {
        if (adapter != null) {
            val listAdapter = adapter as BeerListAdapter
            listAdapter.clear()
            if (items != null)
                listAdapter.addAll(items)
            listAdapter.notifyDataSetChanged()
        }
    }
}