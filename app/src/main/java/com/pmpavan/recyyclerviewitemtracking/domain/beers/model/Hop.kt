package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Hop {
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("amount")
    @Expose
    private var amount: Amount? = null
    @SerializedName("add")
    @Expose
    private var add: String? = null
    @SerializedName("attribute")
    @Expose
    private var attribute: String? = null

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

    fun getAdd(): String? {
        return add
    }

    fun setAdd(add: String) {
        this.add = add
    }

    fun getAttribute(): String? {
        return attribute
    }

    fun setAttribute(attribute: String) {
        this.attribute = attribute
    }


}