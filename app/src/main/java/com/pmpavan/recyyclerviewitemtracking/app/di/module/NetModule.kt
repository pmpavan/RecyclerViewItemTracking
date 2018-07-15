package com.pmpavan.recyyclerviewitemtracking.app.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pmpavan.recyyclerviewitemtracking.data.beers.BeerApi
import com.pmpavan.recyyclerviewitemtracking.data.beers.BeerApiService
import com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.BeerInteractor
import com.pmpavan.recyyclerviewitemtracking.domain.beers.interactor.impl.BeerInteractorImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Gson): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesApiInterface(retrofit: Retrofit): BeerApiService = retrofit.create(
            BeerApiService::class.java)

    @Provides
    @Singleton
    fun providesApi(apiService: BeerApiService): BeerApi = BeerApi(apiService)

    @Provides
    @Singleton
    fun providesGithubInteractor(api: BeerApi): BeerInteractor = BeerInteractorImpl(api)

}