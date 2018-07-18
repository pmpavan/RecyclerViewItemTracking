package com.pmpavan.recyyclerviewitemtracking.ui.beers

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.pmpavan.recyyclerviewitemtracking.R
import com.pmpavan.recyyclerviewitemtracking.databinding.ActivityTrackingBinding
import com.pmpavan.recyyclerviewitemtracking.ui.base.BaseActivity
import com.pmpavan.recyyclerviewitemtracking.ui.beers.adapter.BeerListAdapter
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.BeersViewModel
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.events.ListLoadFailedEvent
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListUiState
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.events.ListLoadedEvent
import android.support.design.widget.Snackbar


class TrackingActivity : BaseActivity() {

    @Inject
    lateinit var eventBus: EventBus
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    @Inject
    lateinit var adapter: BeerListAdapter
    @Inject
    lateinit var listState: BeerListUiState

    private lateinit var viewModel: BeersViewModel
    private lateinit var viewDataBinding: ActivityTrackingBinding

    private val viewTracker: ViewTracker by lazy { ViewTracker() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerForEvents(eventBus)
        invokeDataBinding()
        setupControllers()
        sendRequest()
    }


    private fun invokeDataBinding() {
        viewModel = ViewModelProviders.of(this@TrackingActivity, factory).get(BeersViewModel::class.java)
        viewDataBinding = DataBindingUtil.setContentView(this@TrackingActivity, R.layout.activity_tracking)
        viewDataBinding.vm = viewModel
        viewDataBinding.executePendingBindings()

    }

    private fun setupControllers() {
        adapter.handler = viewModel

//        viewDataBinding.beerList.layoutManager = GridLayoutManager(this, 2)
        viewDataBinding.beerList.adapter = adapter
        viewDataBinding.beers = listState
        viewModel.data.observe(this@TrackingActivity, Observer { t ->
            listState.update(t!!)
        })
    }

    private fun sendRequest() {
        viewModel.onPageLoaded()
    }

    override fun onDestroy() {
        unregisterForEvents(eventBus)
        super.onDestroy()
    }

    private fun showSnackBar(message: String?) {
        val snackBar = Snackbar
                .make(viewDataBinding.parentLayout, message
                        ?: "Some Problem in Server", Snackbar.LENGTH_SHORT)

        snackBar.show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onViewModelInteraction(event: ListLoadFailedEvent) {
        showSnackBar(event.message)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onViewModelInteraction(event: ListLoadedEvent) {
        viewTracker.startTracking(viewDataBinding.beerList)
    }


}
