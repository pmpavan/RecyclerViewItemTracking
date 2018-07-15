package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Volume {
    @SerializedName("value")
    @Expose
    private var value: Int? = null
    @SerializedName("unit")
    @Expose
    private var unit: String? = null

    fun getValue(): Int? {
        return value
    }

    fun setValue(value: Int?) {
        this.value = value
    }

    fun getUnit(): String? {
        return unit
    }

    fun setUnit(unit: String) {
        this.unit = unit
    }
}