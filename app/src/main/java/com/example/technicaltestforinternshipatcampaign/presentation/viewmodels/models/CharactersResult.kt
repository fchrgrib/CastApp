package com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models

import com.example.technicaltestforinternshipatcampaign.api.models.Character

interface CharactersResult {
    data class CharacterRes(val character: List<Character>):CharactersResult
    data class Error(val message :String):CharactersResult
}