package com.pmpavan.recyyclerviewitemtracking.domain.anime.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.pmpavan.recyyclerviewitemtracking.domain.anime.model.Top


class AnimeItem {
    @SerializedName("request_hash")
    @Expose
    private var requestHash: String? = null
    @SerializedName("request_cached")
    @Expose
    private var requestCached: Boolean? = null
    @SerializedName("top")
    @Expose
    private var top: List<Top>? = null

    fun getRequestHash(): String? {
        return requestHash
    }

    fun setRequestHash(requestHash: String) {
        this.requestHash = requestHash
    }

    fun getRequestCached(): Boolean? {
        return requestCached
    }

    fun setRequestCached(requestCached: Boolean?) {
        this.requestCached = requestCached
    }

    fun getTop(): List<Top>? {
        return top
    }

    fun setTop(top: List<Top>) {
        this.top = top
    }

}