package com.example.technicaltestforinternshipatcampaign.repository

import com.example.technicaltestforinternshipatcampaign.api.models.CastCredits
import com.example.technicaltestforinternshipatcampaign.api.models.Character
import com.example.technicaltestforinternshipatcampaign.api.models.Movie
import com.example.technicaltestforinternshipatcampaign.api.models.People

interface CastRepo {
    suspend fun getPeople(id :String) : People
    suspend fun getCastCredits(id :String) : List<CastCredits>
    suspend fun getMovie(id :String) : Movie
    suspend fun getCharacters(id:String) : Character
}