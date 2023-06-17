package com.example.technicaltestforinternshipatcampaign.api

import com.example.technicaltestforinternshipatcampaign.api.models.CastCredits
import com.example.technicaltestforinternshipatcampaign.api.models.Character
import com.example.technicaltestforinternshipatcampaign.api.models.Movie
import com.example.technicaltestforinternshipatcampaign.api.models.People
import retrofit2.http.GET
import retrofit2.http.Path

interface CastAPI {

    @GET("people/{id}")
    suspend fun getPeople(
        @Path("id")
        id:String
    ) :People

    @GET("people/{id}/castcredits")
    suspend fun getCastCredits(
        @Path("id")
        id :String
    ) :List<CastCredits>

    @GET("shows/{id}")
    suspend fun getMovie(
        @Path("id")
        id :String
    ) :Movie

    @GET("characters/{id}")
    suspend fun getCharacters(
        @Path("id")
        id:String
    ) :Character
}