package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class MashTemp {
    @SerializedName("temp")
    @Expose
    private var temp: Temp? = null
    @SerializedName("duration")
    @Expose
    private var duration: Int? = null

    fun getTemp(): Temp? {
        return temp
    }

    fun setTemp(temp: Temp) {
        this.temp = temp
    }

    fun getDuration(): Int? {
        return duration
    }

    fun setDuration(duration: Int?) {
        this.duration = duration
    }
}