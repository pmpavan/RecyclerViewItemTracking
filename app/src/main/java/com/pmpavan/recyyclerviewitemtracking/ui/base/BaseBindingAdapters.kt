package com.pmpavan.recyyclerviewitemtracking.ui.base

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.facebook.drawee.view.SimpleDraweeView
import com.pmpavan.recyyclerviewitemtracking.R
import com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter.BeerListAdapter
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListItemUiState
import com.squareup.picasso.Picasso

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

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun SimpleDraweeView.setImageUrl(imageUrl: String?) {
        if (imageUrl != null) {
            setImageURI(imageUrl)
        }
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun ImageView.setImageUrl(imageUrl: String?) {
        if (imageUrl != null) {
            Picasso.get().load(imageUrl).placeholder(R.mipmap.ic_launcher).into(this)
        }
    }


    @BindingAdapter("android:visibility")
    @JvmStatic
    fun View.setVisibility(imageUrl: Boolean?) {
        if (imageUrl != null) {
            visibility = if (imageUrl) View.VISIBLE else View.GONE
        }
    }
}