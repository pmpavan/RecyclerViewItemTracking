package com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pmpavan.recyyclerviewitemtracking.R
import com.pmpavan.recyyclerviewitemtracking.databinding.BeerListItemBinding
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListItemUiState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BeerListAdapter @Inject constructor(val context: Context) :  PagedListAdapter<BeerListItemUiState, RecyclerView.ViewHolder>(BeerDiffCallBack ) {

    private var items: MutableList<BeerListItemUiState> = mutableListOf()

    var handler: BeerListItemUiState.BeerItemClickHandler? = null


    fun setItems(items: MutableList<BeerListItemUiState>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): BeerListItemUiState {
        return items[position]
    }

    override fun getItem(position: Int): BeerListItemUiState {
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

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)

//        Log.i("TAGG", "onViewDetachedFromWindow " + ((holder as BeerItemViewHolder).binding.root.tag as BeerListItemUiState).name)
//        (holder as BeerItemViewHolder).onStopTimer()

    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
//        Log.i("TAGG", "onViewAttachedToWindow " + ((holder as BeerItemViewHolder).binding.root.tag as BeerListItemUiState).name)
//        (holder as BeerItemViewHolder).onStartTimer()
    }

    internal class BeerItemViewHolder(val binding: BeerListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BeerListItemUiState) {
            binding.vm = item
            binding.root.tag = item
            binding.executePendingBindings()
        }

        fun onStartTimer() {
            disposable = Observable.timer(3, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.i("TAGG", "3 second up " + binding.root.tag)
                    },
                            {

                                Log.i("TAGG", "3 second down " + binding.root.tag)
                            })
        }

        fun onStopTimer() {
            disposable?.dispose()
        }

        var disposable: Disposable? = null

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): BeerItemViewHolder {
                val binding: BeerListItemBinding = DataBindingUtil.inflate(inflater, R.layout.beer_list_item, parent, false)
                return BeerItemViewHolder(binding)
            }

        }
    }
}