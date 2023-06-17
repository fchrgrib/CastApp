package com.example.technicaltestforinternshipatcampaign.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CastCredits(
    @Json(name = "self")
    val self:Boolean,
    @Json(name = "voice")
    val voice:Boolean,
    @Json(name = "_links")
    val links:LinksCastCredits
)

@JsonClass(generateAdapter = true)
data class LinksCastCredits(
    @Json(name = "show")
    val show:SelfRac,
    @Json(name = "character")
    val character:SelfRac
)
