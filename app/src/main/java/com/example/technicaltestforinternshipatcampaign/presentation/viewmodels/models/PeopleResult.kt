package com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models

import com.example.technicaltestforinternshipatcampaign.api.models.People

sealed interface PeopleResult{
    data class PeopleRes(val people: People):PeopleResult
    data class Error(val message :String):PeopleResult
}