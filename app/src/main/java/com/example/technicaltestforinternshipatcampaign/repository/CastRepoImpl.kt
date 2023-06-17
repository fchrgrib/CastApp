package com.example.technicaltestforinternshipatcampaign.repository

import com.example.technicaltestforinternshipatcampaign.api.CastAPI
import com.example.technicaltestforinternshipatcampaign.api.models.CastCredits
import com.example.technicaltestforinternshipatcampaign.api.models.Character
import com.example.technicaltestforinternshipatcampaign.api.models.Movie
import com.example.technicaltestforinternshipatcampaign.api.models.People
import javax.inject.Inject

class CastRepoImpl @Inject constructor(
    private val castAPI: CastAPI
):CastRepo {
    override suspend fun getPeople(id: String): People {
        return castAPI.getPeople(id)
    }

    override suspend fun getCastCredits(id: String): List<CastCredits> {
        return castAPI.getCastCredits(id)
    }

    override suspend fun getMovie(id: String): Movie {
        return castAPI.getMovie(id)
    }

    override suspend fun getCharacters(id: String): Character {
        return castAPI.getCharacters(id)
    }
}