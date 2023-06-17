package com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models

import com.example.technicaltestforinternshipatcampaign.api.models.Movie

sealed interface MovieResult{
    data class MovieRes(val movie: Movie):MovieResult
    data class Error(val message :String):MovieResult
}