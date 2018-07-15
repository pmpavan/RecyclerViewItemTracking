package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Method {
    @SerializedName("mash_temp")
    @Expose
    private var mashTemp: List<MashTemp>? = null
    @SerializedName("fermentation")
    @Expose
    private var fermentation: Fermentation? = null
    @SerializedName("twist")
    @Expose
    private var twist: String? = null

    fun getMashTemp(): List<MashTemp>? {
        return mashTemp
    }

    fun setMashTemp(mashTemp: List<MashTemp>) {
        this.mashTemp = mashTemp
    }

    fun getFermentation(): Fermentation? {
        return fermentation
    }

    fun setFermentation(fermentation: Fermentation) {
        this.fermentation = fermentation
    }

    fun getTwist(): String? {
        return twist
    }

    fun setTwist(twist: String) {
        this.twist = twist
    }
}