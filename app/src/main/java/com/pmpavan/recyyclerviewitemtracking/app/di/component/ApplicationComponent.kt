package com.pmpavan.recyyclerviewitemtracking.app.di.component

import com.pmpavan.recyyclerviewitemtracking.app.RecyclerViewTrackingApplication
import com.pmpavan.recyyclerviewitemtracking.app.di.module.ActivityInjectionModule
import com.pmpavan.recyyclerviewitemtracking.app.di.module.ApplicationModule
import com.pmpavan.recyyclerviewitemtracking.app.di.module.NetModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    AndroidInjectionModule::class,
    ActivityInjectionModule::class,
    NetModule::class])
interface ApplicationComponent {

    fun inject(app: RecyclerViewTrackingApplication)

}