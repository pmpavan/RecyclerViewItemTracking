package com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pmpavan.recyyclerviewitemtracking.R
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListItemUiState
import javax.inject.Inject
import com.pmpavan.recyyclerviewitemtracking.databinding.BeerListItemBinding

class BeerListAdapter @Inject constructor(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: MutableList<BeerListItemUiState> = mutableListOf()

    var handler: BeerListItemUiState.BeerItemClickHandler? = null


    fun setItems(items: MutableList<BeerListItemUiState>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun getItem(position: Int): BeerListItemUiState {
        return items[position]
    }

    fun addAll(items: MutableList<BeerListItemUiState>) {
        this.items.addAll(items)
    }

    fun clear() {
        items.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BeerItemViewHolder.create(LayoutInflater.from(parent.context), parent)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = items[position]
        (holder as BeerItemViewHolder).bind(model)
        holder.binding.root.setOnClickListener { _ ->
            if (handler != null)
                handler!!.onItemClick(position, model)
        }
    }

    internal class BeerItemViewHolder(val binding: BeerListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BeerListItemUiState) {
            binding.vm = item
            binding.executePendingBindings()
        }

        companion object {

            fun create(inflater: LayoutInflater, parent: ViewGroup): BeerItemViewHolder {
                val binding: BeerListItemBinding = DataBindingUtil.inflate(inflater, R.layout.beer_list_item, parent, false)
                return BeerItemViewHolder(binding)
            }
        }
    }
}