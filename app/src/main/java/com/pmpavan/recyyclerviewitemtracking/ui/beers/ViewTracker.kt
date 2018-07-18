package com.pmpavan.recyyclerviewitemtracking.ui.beers

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewTreeObserver
import com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter.BeerListAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class ViewTracker {

    private var firstTrackFlag = false
    private val viewsViewed = ArrayList<Int>()
    private lateinit var viewTreeObserver: ViewTreeObserver
    private val hashMap = HashMap<Int, Disposable>()
    private lateinit var mainRecyclerView: RecyclerView


    private fun setRecyclerView(recyclerView: RecyclerView) {
        mainRecyclerView = recyclerView
    }

    // Start the tracking process.
    fun startTracking(recyclerView: RecyclerView) {
        setRecyclerView(recyclerView)

        viewTreeObserver = recyclerView.viewTreeObserver
        viewTreeObserver.addOnGlobalLayoutListener {
            if (!firstTrackFlag) {

                analyseView(recyclerView)

                firstTrackFlag = true
            }
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView,
                                              newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    val firstVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager)
                            .findFirstVisibleItemPosition()

                    val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager)
                            .findLastVisibleItemPosition()
                    for (position in 0 until viewsViewed.size) {
                        if (position < firstVisibleItemPosition && position > lastVisibleItemPosition) {
                            clearViewViewed(position)
                        }
                    }
                }

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    analyseView(recyclerView)
                }
            }
        })
    }

    private fun analyseView(recyclerView: RecyclerView) {

        val firstVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager)
                .findFirstVisibleItemPosition()

        val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager)
                .findLastVisibleItemPosition()

        analyseAndAddViewData(firstVisibleItemPosition,
                lastVisibleItemPosition)
    }


    private fun clearViewViewed(position: Int) {
        viewsViewed.remove(position)

        onStopTimer(position, hashMap[position])
    }

    private fun addViewsViewed(viewPosition: Int) {
        viewsViewed.add(viewPosition)

        hashMap[viewPosition] = onStartTimer(viewPosition)
    }

    private fun analyseAndAddViewData(firstVisibleItemPosition: Int,
                                      lastVisibleItemPosition: Int) {

        Log.i("ViewTracker", "first $firstVisibleItemPosition last $lastVisibleItemPosition")
        // Analyze all the views
        for (viewPosition in firstVisibleItemPosition..lastVisibleItemPosition) {
            Log.i("ViewTracker", viewPosition.toString())
            addViewsViewed(viewPosition)
        }
    }

    private fun onStartTimer(viewPosition: Int): Disposable {
        return Observable.timer(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(viewPosition)
                }, {
                    onError(it, viewPosition)
                })
    }

    private fun onSuccess(position: Int) {
        Log.i("ViewTracker", "3 second up $position ${(mainRecyclerView.adapter as BeerListAdapter).getItem(position).name}")

    }

    private fun onError(throwable: Throwable, viewPosition: Int) {
//        Log.i("ViewTracker", "$viewPosition")

    }

    private fun onStopTimer(position: Int, disposable: Disposable?) {
        disposable?.dispose()
        Log.i("ViewTracker", "view tracking stopped $position")
    }

}