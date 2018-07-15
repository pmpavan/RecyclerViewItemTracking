package com.pmpavan.recyyclerviewitemtracking.app.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus
import javax.inject.Singleton


@Module
class ApplicationModule(val app: Application) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return app
    }

    @Singleton
    @Provides
    fun provideApplication(): Application {
        return app
    }

    @Singleton
    @Provides
    fun getEventBus(): EventBus = EventBus.getDefault()
}