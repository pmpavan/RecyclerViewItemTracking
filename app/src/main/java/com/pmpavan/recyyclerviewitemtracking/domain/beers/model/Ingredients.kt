package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Ingredients {

    @SerializedName("malt")
    @Expose
    private var malt: List<Malt>? = null
    @SerializedName("hops")
    @Expose
    private var hops: List<Hop>? = null
    @SerializedName("yeast")
    @Expose
    private var yeast: String? = null

    fun getMalt(): List<Malt>? {
        return malt
    }

    fun setMalt(malt: List<Malt>) {
        this.malt = malt
    }

    fun getHops(): List<Hop>? {
        return hops
    }

    fun setHops(hops: List<Hop>) {
        this.hops = hops
    }

    fun getYeast(): String? {
        return yeast
    }

    fun setYeast(yeast: String) {
        this.yeast = yeast
    }

}