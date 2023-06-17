package com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models

import com.example.technicaltestforinternshipatcampaign.api.models.CastCredits

sealed interface CastCreditsResult{
    data class CastCreditsRes(val castCredits: List<CastCredits>):CastCreditsResult
    data class Error(val message :String):CastCreditsResult
}