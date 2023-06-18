package com.example.technicaltestforinternshipatcampaign.presentation.ui.utils

import com.example.technicaltestforinternshipatcampaign.api.models.CastCredits
import com.example.technicaltestforinternshipatcampaign.api.models.Character
import com.example.technicaltestforinternshipatcampaign.api.models.Movie


data class Result(val movie:List<String>,val character:List<String>)

fun separateList(casts :List<CastCredits>):Result{
    val movie: MutableList<String> = mutableListOf()
    val character: MutableList<String> = mutableListOf()
    val regex = """\d+""".toRegex()


    for (cast:CastCredits in casts){
        val movieNum = regex.find(cast.links.show.href)
        val characterNum = regex.find(cast.links.character.href)

        movie += movieNum?.value!!
        character += characterNum?.value!!
    }

    return Result(movie = movie, character = character)
}

fun separateImagesMovies(movies:List<Movie>):List<String>{
    val listOfImage = mutableListOf<String>()
    for (movie:Movie in movies){
        if(movie.image!!.medium != "") listOfImage.add(movie.image!!.medium)
    }
    return listOfImage
}

fun separateImageCharacter(characters:List<Character>):List<String>{
    val listOfImage = mutableListOf<String>()
    for(character:Character in characters){
        if (character.image!!.medium!="") listOfImage.add(character.image!!.medium)
    }
    return listOfImage
}

fun main() {
    val url = "https://api.tvmaze.com/characters/878558"
    val regex = """\d+""".toRegex()
    val matchResult = regex.find(url)

    val number = matchResult?.value
    println(number) // Output: 123
}