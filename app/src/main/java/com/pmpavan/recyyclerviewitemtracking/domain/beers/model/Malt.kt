package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Malt {
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("amount")
    @Expose
    private var amount: Amount? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAmount(): Amount? {
        return amount
    }

    fun setAmount(amount: Amount) {
        this.amount = amount
    }

}