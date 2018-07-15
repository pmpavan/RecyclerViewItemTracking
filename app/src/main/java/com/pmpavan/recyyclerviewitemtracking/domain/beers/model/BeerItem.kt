package com.pmpavan.recyyclerviewitemtracking.domain.beers.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class BeerItem {
    @SerializedName("id")
    @Expose
    private var id: Long? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("tagline")
    @Expose
    private var tagline: String? = null
    @SerializedName("first_brewed")
    @Expose
    private var firstBrewed: String? = null
    @SerializedName("description")
    @Expose
    private var description: String? = null
    @SerializedName("image_url")
    @Expose
    private var imageUrl: String? = null
    @SerializedName("abv")
    @Expose
    private var abv: Double? = null
    @SerializedName("ibu")
    @Expose
    private var ibu: Double? = null
    @SerializedName("target_fg")
    @Expose
    private var targetFg: Double? = null
    @SerializedName("target_og")
    @Expose
    private var targetOg: Double? = null
    @SerializedName("ebc")
    @Expose
    private var ebc: Double? = null
    @SerializedName("srm")
    @Expose
    private var srm: Double? = null
    @SerializedName("ph")
    @Expose
    private var ph: Double? = null
    @SerializedName("attenuation_level")
    @Expose
    private var attenuationLevel: Double? = null
    @SerializedName("volume")
    @Expose
    private var volume: Volume? = null
    @SerializedName("boil_volume")
    @Expose
    private var boilVolume: BoilVolume? = null
    @SerializedName("method")
    @Expose
    private var method: Method? = null
    @SerializedName("ingredients")
    @Expose
    private var ingredients: Ingredients? = null
    @SerializedName("food_pairing")
    @Expose
    private var foodPairing: List<String>? = null
    @SerializedName("brewers_tips")
    @Expose
    private var brewersTips: String? = null
    @SerializedName("contributed_by")
    @Expose
    private var contributedBy: String? = null

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getTagline(): String? {
        return tagline
    }

    fun setTagline(tagline: String) {
        this.tagline = tagline
    }

    fun getFirstBrewed(): String? {
        return firstBrewed
    }

    fun setFirstBrewed(firstBrewed: String) {
        this.firstBrewed = firstBrewed
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getImageUrl(): String? {
        return imageUrl
    }

    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
    }

    fun getAbv(): Double? {
        return abv
    }

    fun setAbv(abv: Double?) {
        this.abv = abv
    }

    fun getIbu(): Double? {
        return ibu
    }

    fun setIbu(ibu: Double?) {
        this.ibu = ibu
    }

    fun getTargetFg(): Double? {
        return targetFg
    }

    fun setTargetFg(targetFg: Double?) {
        this.targetFg = targetFg
    }

    fun getTargetOg(): Double? {
        return targetOg
    }

    fun setTargetOg(targetOg: Double?) {
        this.targetOg = targetOg
    }

    fun getEbc(): Double? {
        return ebc
    }

    fun setEbc(ebc: Double?) {
        this.ebc = ebc
    }

    fun getSrm(): Double? {
        return srm
    }

    fun setSrm(srm: Double?) {
        this.srm = srm
    }

    fun getPh(): Double? {
        return ph
    }

    fun setPh(ph: Double?) {
        this.ph = ph
    }

    fun getAttenuationLevel(): Double? {
        return attenuationLevel
    }

    fun setAttenuationLevel(attenuationLevel: Double?) {
        this.attenuationLevel = attenuationLevel
    }

    fun getVolume(): Volume? {
        return volume
    }

    fun setVolume(volume: Volume) {
        this.volume = volume
    }

    fun getBoilVolume(): BoilVolume? {
        return boilVolume
    }

    fun setBoilVolume(boilVolume: BoilVolume) {
        this.boilVolume = boilVolume
    }

    fun getMethod(): Method? {
        return method
    }

    fun setMethod(method: Method) {
        this.method = method
    }

    fun getIngredients(): Ingredients? {
        return ingredients
    }

    fun setIngredients(ingredients: Ingredients) {
        this.ingredients = ingredients
    }

    fun getFoodPairing(): List<String>? {
        return foodPairing
    }

    fun setFoodPairing(foodPairing: List<String>) {
        this.foodPairing = foodPairing
    }

    fun getBrewersTips(): String? {
        return brewersTips
    }

    fun setBrewersTips(brewersTips: String) {
        this.brewersTips = brewersTips
    }

    fun getContributedBy(): String? {
        return contributedBy
    }

    fun setContributedBy(contributedBy: String) {
        this.contributedBy = contributedBy
    }

    override fun toString(): String {
        return "BeerItem(id=$id, " +
                "name=$name, " +
                "tagline=$tagline, " +
                "firstBrewed=$firstBrewed, " +
                "description=$description, " +
                "imageUrl=$imageUrl, " +
                "abv=$abv, ibu=$ibu, " +
                "targetFg=$targetFg, " +
                "targetOg=$targetOg, " +
                "ebc=$ebc, srm=$srm, " +
                "ph=$ph, " +
                "attenuationLevel=$attenuationLevel, " +
                "volume=$volume, boilVolume=$boilVolume, " +
                "method=$method, ingredients=$ingredients, " +
                "foodPairing=$foodPairing, " +
                "brewersTips=$brewersTips, " +
                "contributedBy=$contributedBy)"
    }


}