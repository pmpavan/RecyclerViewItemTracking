package com.pmpavan.recyyclerviewitemtracking.domain.anime.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Top {

    @SerializedName("mal_id")
    @Expose
    private var malId: Long? = null
    @SerializedName("rank")
    @Expose
    private var rank: Int? = null
    @SerializedName("url")
    @Expose
    private var url: String? = null
    @SerializedName("image_url")
    @Expose
    private var imageUrl: String? = null
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("score")
    @Expose
    private var score: String? = null
    @SerializedName("members")
    @Expose
    private var members: Int? = null
    @SerializedName("airing_start")
    @Expose
    private var airingStart: String? = null
    @SerializedName("airing_end")
    @Expose
    private var airingEnd: String? = null
    @SerializedName("episodes")
    @Expose
    private var episodes: Int? = null

    fun getMalId(): Long? {
        return malId
    }

    fun setMalId(malId: Long?) {
        this.malId = malId
    }

    fun getRank(): Int? {
        return rank
    }

    fun setRank(rank: Int?) {
        this.rank = rank
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getImageUrl(): String? {
        return imageUrl
    }

    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getScore(): String? {
        return score
    }

    fun setScore(score: String) {
        this.score = score
    }

    fun getMembers(): Int? {
        return members
    }

    fun setMembers(members: Int?) {
        this.members = members
    }

    fun getAiringStart(): String? {
        return airingStart
    }

    fun setAiringStart(airingStart: String) {
        this.airingStart = airingStart
    }

    fun getAiringEnd(): String? {
        return airingEnd
    }

    fun setAiringEnd(airingEnd: String) {
        this.airingEnd = airingEnd
    }

    fun getEpisodes(): Int? {
        return episodes
    }

    fun setEpisodes(episodes: Int?) {
        this.episodes = episodes
    }
}