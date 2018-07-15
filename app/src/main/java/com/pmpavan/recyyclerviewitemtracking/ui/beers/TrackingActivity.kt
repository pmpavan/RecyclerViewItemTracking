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
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.events.ViewModelEvent
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.uistate.BeerListUiState
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerForEvents(eventBus)
        invokeDataBinding()
        setupControllers()
    }

    private fun invokeDataBinding() {
        viewModel = ViewModelProviders.of(this@TrackingActivity, factory).get(BeersViewModel::class.java)
        viewDataBinding = DataBindingUtil.setContentView(this@TrackingActivity, R.layout.activity_tracking)
        viewDataBinding.vm = viewModel
        viewDataBinding.executePendingBindings()

    }

    private fun setupControllers() {
        adapter.handler = viewModel

        viewDataBinding.beerList.adapter = adapter
        viewDataBinding.beers = listState
        viewModel.data.observe(this@TrackingActivity, Observer { t ->
            listState.update(t!!)
        })

    }

    override fun onStop() {
        super.onStop()
        unregisterForEvents(eventBus)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onViewModelInteraction(event: ViewModelEvent) {
    }
}
