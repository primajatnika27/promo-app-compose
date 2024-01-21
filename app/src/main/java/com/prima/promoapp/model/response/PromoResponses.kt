package com.prima.promoapp.model.response

import com.google.gson.annotations.SerializedName

data class PromoResponses(
    val data: List<Datum>
)

data class Datum (
    val id: Long,
    val attributes: Attributes
)

data class Attributes(
    @SerializedName("title") val title: String,
    @SerializedName("count") val count: Int,
    @SerializedName("alt") val alt: Int,
    @SerializedName("desc") val description: String,
    @SerializedName("desc_promo") val descriptionPromo: String,
    @SerializedName("latitude") val latitude: String,
    @SerializedName("longitude") val longitude: String,
    @SerializedName("lokasi") val location: String,
    @SerializedName("nama") val name: String,
    @SerializedName("name_promo") val promoName: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
)