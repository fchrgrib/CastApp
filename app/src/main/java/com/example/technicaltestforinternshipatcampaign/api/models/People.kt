package com.example.technicaltestforinternshipatcampaign.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



@JsonClass(generateAdapter = true)
data class People(
    @Json(name = "id")
    val id:Int,
    @Json(name = "url")
    val url:String,
    @Json(name = "name")
    val name:String,
    @Json(name = "country")
    val country: CountryRac,
    @Json(name = "birthday")
    val birthday:String,
    @Json(name = "deathday")
    val deathDay:String?,
    @Json(name = "gender")
    val gender:String,
    @Json(name = "image")
    var image: ImageRac?,
    @Json(name = "updated")
    val updated:Long,
    @Json(name = "_links")
    val links:LinksRac
){
    init {
        image = image?:ImageRac("","")
    }
}


@JsonClass(generateAdapter = true)
data class ImageRac(
    @Json(name = "medium")
    val imageMediumSize:String,
    @Json(name = "original")
    val imageOriginalSize:String
)

@JsonClass(generateAdapter = true)
data class CountryRac(
    @Json(name = "name")
    val name: String,
    @Json(name = "code")
    val code:String,
    @Json(name = "timezone")
    val timeZone:String
)

@JsonClass(generateAdapter = true)
data class LinksRac(
    @Json(name = "self")
    val self:SelfRac
)

@JsonClass(generateAdapter = true)
data class SelfRac(
    @Json(name = "href")
    val href:String
)
