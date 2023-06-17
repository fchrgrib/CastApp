package com.example.technicaltestforinternshipatcampaign.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.CastCreditsResult
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.CharactersResult
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.MovieResult
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.PeopleResult
import com.example.technicaltestforinternshipatcampaign.repository.CastRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val castRepoImpl: CastRepoImpl
) : ViewModel() {

    private val _peopleResult = MutableStateFlow<PeopleResult?>(null)
    private val _characterResult = MutableStateFlow<CharactersResult?>(null)
    private val _castCreditsResult = MutableStateFlow<CastCreditsResult?>(null)
    private val _movieResult = MutableStateFlow<MovieResult?>(null)


    val peopleResult = _peopleResult
    val characterResult = _characterResult
    val castCreditResult = _castCreditsResult
    val movieResult = _movieResult

    fun getPeople(id :String){
        viewModelScope.launch {
            try {
                val response = castRepoImpl.getPeople(id)
                _peopleResult.emit(PeopleResult.PeopleRes(response))
            }catch (e:Exception){
                _peopleResult.emit(PeopleResult.Error(e.localizedMessage?:""))
            }
        }
    }

    fun getCastCredits(id:String){
        viewModelScope.launch {
            try {
                val response = castRepoImpl.getCastCredits(id)
                _castCreditsResult.emit(CastCreditsResult.CastCreditsRes(response))
            }catch (e:Exception){
                _castCreditsResult.emit(CastCreditsResult.Error(e.localizedMessage?:""))
            }
        }
    }

    fun getMovie(id:String){
        viewModelScope.launch {
            try {
                val response = castRepoImpl.getMovie(id)
                _movieResult.emit(MovieResult.MovieRes(response))
            }catch (e:Exception){
                _movieResult.emit(MovieResult.Error(e.localizedMessage?:""))
            }
        }
    }

    fun getCharacters(id:String){
        viewModelScope.launch {
            try {
                val response = castRepoImpl.getCharacters(id)
                _characterResult.emit(CharactersResult.CharacterRes(response))
            }catch (e:Exception){
                _characterResult.emit(CharactersResult.Error(e.localizedMessage?:""))
            }
        }
    }
}