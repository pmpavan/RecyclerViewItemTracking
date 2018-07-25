package com.pmpavan.recyyclerviewitemtracking.ui.beers

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter.BeerListAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class ViewTracker {

    private var firstTrackFlag = false
    private val viewsViewed = ArrayList<Int>()
    private val hashMap = HashMap<Int, Disposable>()
    private lateinit var mainRecyclerView: RecyclerView
    private val ITEM_VIEWED_TIME_LIMIT_IN_MILLIS = 300.toLong()


    private fun setRecyclerView(recyclerView: RecyclerView) {
        mainRecyclerView = recyclerView
    }

    // Start the tracking process.
    fun startTracking(recyclerView: RecyclerView) {
        setRecyclerView(recyclerView)

        recyclerView.viewTreeObserver
                .addOnGlobalLayoutListener {
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

                    val (firstVisibleItemPosition, lastVisibleItemPosition) = getFirstAndLastViewedPosition(recyclerView)

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

    private fun getFirstAndLastViewedPosition(recyclerView: RecyclerView): Pair<Int, Int> {
        val firstVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager)
                .findFirstVisibleItemPosition()

        val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager)
                .findLastVisibleItemPosition()
        return Pair(firstVisibleItemPosition, lastVisibleItemPosition)
    }

    private fun analyseView(recyclerView: RecyclerView) {

        val (firstVisibleItemPosition, lastVisibleItemPosition) = getFirstAndLastViewedPosition(recyclerView)

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
        // Analyze all the views
        for (viewPosition in firstVisibleItemPosition..lastVisibleItemPosition) {
            addViewsViewed(viewPosition)
        }
    }

    private fun onStartTimer(viewPosition: Int): Disposable {
        return Observable.timer(ITEM_VIEWED_TIME_LIMIT_IN_MILLIS, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(viewPosition)
                }, {
                    onError(it, viewPosition)
                })
    }

    private fun onSuccess(position: Int) {
        Log.i("ViewTracker", "${(mainRecyclerView.adapter as BeerListAdapter).getItemAt(position).name} has been viewed by the user for 300 milliseconds")
    }

    private fun onError(throwable: Throwable, viewPosition: Int) {
//        Log.i("ViewTracker", "$viewPosition")
    }

    private fun onStopTimer(position: Int, disposable: Disposable?) {
        disposable?.dispose()
    }

}