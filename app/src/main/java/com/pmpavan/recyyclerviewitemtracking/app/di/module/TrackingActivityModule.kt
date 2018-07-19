package com.pmpavan.recyyclerviewitemtracking.app.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pmpavan.recyyclerviewitemtracking.app.di.scope.ViewModelKey
import com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.BeerNetworkDataSource
import com.pmpavan.recyyclerviewitemtracking.viewmodel.base.ViewModelFactory
import com.pmpavan.recyyclerviewitemtracking.viewmodel.beers.BeersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TrackingActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(BeersViewModel::class)
    abstract fun bindBeersViewModel(model: BeersViewModel): ViewModel

    @Binds
    abstract fun bindBeersViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun bindBeerDataSource(): BeerNetworkDataSource
}