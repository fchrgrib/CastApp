package com.example.technicaltestforinternshipatcampaign.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    var image: Image?,
    @Json(name = "_links")
    val links: Links,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
){
    init {
        image = image?:Image("","")
    }
}

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "medium")
    val medium: String,
    @Json(name = "original")
    val original: String
)
@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "self")
    val self: Self
)

@JsonClass(generateAdapter = true)
data class Self(
    @Json(name = "href")
    val href: String
)