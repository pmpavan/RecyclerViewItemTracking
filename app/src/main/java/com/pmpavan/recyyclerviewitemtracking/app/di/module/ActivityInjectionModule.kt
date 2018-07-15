package com.pmpavan.recyyclerviewitemtracking.app.di.module

import com.pmpavan.recyyclerviewitemtracking.ui.beers.TrackingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectionModule {
    @ContributesAndroidInjector(modules = [TrackingActivityModule::class])
    abstract fun contributeTrackingActivity(): TrackingActivity
}