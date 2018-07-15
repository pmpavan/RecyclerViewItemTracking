package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Amount {
    @SerializedName("value")
    @Expose
    private var value: Double? = null
    @SerializedName("unit")
    @Expose
    private var unit: String? = null

    fun getValue(): Double? {
        return value
    }

    fun setValue(value: Double?) {
        this.value = value
    }

    fun getUnit(): String? {
        return unit
    }

    fun setUnit(unit: String) {
        this.unit = unit
    }
}