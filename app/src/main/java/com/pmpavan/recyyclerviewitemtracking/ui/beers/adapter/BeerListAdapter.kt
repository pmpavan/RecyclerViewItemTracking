package com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pmpavan.recyyclerviewitemtracking.R
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListItemUiState
import javax.inject.Inject
import com.pmpavan.recyyclerviewitemtracking.databinding.BeerListItemBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

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
            timer = Observable.timer(3, TimeUnit.SECONDS)
            timer!!.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.i("TAGG", "3 second up " + item.name)
                    },
                            {

                                Log.i("TAGG", "3 second doown")
                            })
        }

        companion object {
            var timer: Observable<Long>? = null
            fun create(inflater: LayoutInflater, parent: ViewGroup): BeerItemViewHolder {
                val binding: BeerListItemBinding = DataBindingUtil.inflate(inflater, R.layout.beer_list_item, parent, false)
                return BeerItemViewHolder(binding)
            }
        }
    }
}