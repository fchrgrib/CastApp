package com.example.technicaltestforinternshipatcampaign.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "averageRuntime")
    val averageRuntime: Int,
    @Json(name = "dvdCountry")
    val dvdCountry: String?,
    @Json(name = "ended")
    val ended: String,
    @Json(name = "externals")
    val externals: Externals,
    @Json(name = "genres")
    val genres: List<String>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    var image: ImageMovie?,
    @Json(name = "language")
    val language: String,
    @Json(name = "_links")
    val links: LinksMovie,
    @Json(name = "name")
    val name: String,
    @Json(name = "network")
    var network: Network?,
    @Json(name = "officialSite")
    var officialSite: String?,
    @Json(name = "premiered")
    val premiered: String,
    @Json(name = "rating")
    val rating: Rating,
    @Json(name = "runtime")
    val runtime: Int,
    @Json(name = "schedule")
    val schedule: Schedule,
    @Json(name = "status")
    val status: String,
    @Json(name = "summary")
    val summary: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "updated")
    val updated: Int,
    @Json(name = "url")
    val url: String,
    @Json(name = "webChannel")
    var webChannel: Any?,
    @Json(name = "weight")
    val weight: Int
){
    init {
        officialSite = officialSite ?:""
        webChannel = webChannel ?:""
        network = network?: Network(CountryMovie("","",""),0,"","")
        image = image?:ImageMovie("","")
    }
}

@JsonClass(generateAdapter = true)
data class LinksMovie(
    @Json(name = "previousepisode")
    val previousEpisode: PreviousEpisode,
    @Json(name = "self")
    val self: SelfMovie
)

@JsonClass(generateAdapter = true)
data class ImageMovie(
    @Json(name = "medium")
    val medium: String,
    @Json(name = "original")
    val original: String
)

@JsonClass(generateAdapter = true)
data class Externals(
    @Json(name = "imdb")
    val imdb: String,
    @Json(name = "thetvdb")
    val theTvDb: Int,
    @Json(name = "tvrage")
    var tvRage: Int?
){
    init {
        tvRage = tvRage?:0
    }
}

@JsonClass(generateAdapter = true)
data class Network(
    @Json(name = "country")
    val country: CountryMovie,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "officialSite")
    var officialSite: String?
){
    init {
        officialSite = officialSite?:""
    }
}

@JsonClass(generateAdapter = true)
data class PreviousEpisode(
    @Json(name = "href")
    val href: String
)

@JsonClass(generateAdapter = true)
data class Rating(
    @Json(name = "average")
    var average: Double?
){
    init {
        average = average?:0.0
    }
}

@JsonClass(generateAdapter = true)
data class Schedule(
    @Json(name = "days")
    val days: List<String>,
    @Json(name = "time")
    val time: String
)
@JsonClass(generateAdapter = true)
data class SelfMovie(
    @Json(name = "href")
    val href: String
)

@JsonClass(generateAdapter = true)
data class CountryMovie(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "timezone")
    val timezone: String
)