package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Fermentation {

    @SerializedName("temp")
    @Expose
    private var temp: Temp? = null

    fun getTemp(): Temp? {
        return temp
    }

    fun setTemp(temp: Temp) {
        this.temp = temp
    }
}