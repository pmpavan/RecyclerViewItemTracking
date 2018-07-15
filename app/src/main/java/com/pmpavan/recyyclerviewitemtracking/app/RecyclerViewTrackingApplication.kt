package com.pmpavan.recyyclerviewitemtracking.app

import android.app.Activity
import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.pmpavan.recyyclerviewitemtracking.app.di.component.DaggerApplicationComponent
import com.pmpavan.recyyclerviewitemtracking.app.di.module.ApplicationModule
import com.pmpavan.recyyclerviewitemtracking.app.di.module.NetModule
import com.pmpavan.recyyclerviewitemtracking.app.util.AppConstants
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class RecyclerViewTrackingApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }


    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .netModule(NetModule(AppConstants.BASE_URL))
                .build()
                .inject(this)
    }

}