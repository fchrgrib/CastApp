package com.example.technicaltestforinternshipatcampaign.presentation.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.technicaltestforinternshipatcampaign.R
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.CastsAppTheme
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.BioCharacter
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.Filmography
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.PhotosSection
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.SmallSpacer
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.VideoCharacter
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.isFirstTimeUserToScreen
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.manipulateActivityUserToScreen
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.separateImageCharacter
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.separateImagesMovies
import com.example.technicaltestforinternshipatcampaign.presentation.ui.utils.separateList
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.MainViewModel
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.CastCreditsResult
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.CharactersResult
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.MovieResult
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.PeopleResult
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    mainViewModel: MainViewModel
) {
    val context = LocalContext.current

    val peopleResult = mainViewModel.peopleResult.collectAsState(null).value
    val characterResult = mainViewModel.characterResult.collectAsState(null).value
    val castCreditResult = mainViewModel.castCreditResult.collectAsState(null).value
    val movieResult = mainViewModel.movieResult.collectAsState(null).value

    var triggerRequestCredits:Boolean by rememberSaveable { mutableStateOf(false) }
    val listOfMovie = mutableListOf<String>()
    val listOfCharacter = mutableListOf<String>()

    MainScreenPr(
        castMainPicture = if (peopleResult is PeopleResult.PeopleRes) peopleResult.people.image!!.imageOriginalSize else "",
        descriptionOfCast = stringResource(id = R.string.rachel_description),
        dateBirthDayCast = if (peopleResult is PeopleResult.PeopleRes) peopleResult.people.birthday else "",
        allPhotosOfCast = if (characterResult is CharactersResult.CharacterRes) separateImageCharacter(characterResult.character) else listOf(),
        moviesRelateWithCast = if (movieResult is MovieResult.MovieRes) separateImagesMovies(movieResult.movie) else listOf(),
        paddingOfContent = 9.dp
    )


    if(isFirstTimeUserToScreen(context)){
        manipulateActivityUserToScreen(context,false)
        LaunchedEffect(Unit){
            val deferredResult = listOf(
                async { mainViewModel.getPeople("2") },
                async { mainViewModel.getCastCredits("2") }
            )
            deferredResult.awaitAll()
            triggerRequestCredits = true
        }
    }

    if (
        triggerRequestCredits&&
        castCreditResult is CastCreditsResult.CastCreditsRes
    ){
        triggerRequestCredits = false

        val resultCast = separateList(castCreditResult.castCredits)
        listOfMovie.addAll(resultCast.movie)
        listOfCharacter.addAll(resultCast.character)

        LaunchedEffect(Unit){
            val deferredResult = listOf(
                async { mainViewModel.getMovie(listOfMovie) },
                async { mainViewModel.getCharacters(listOfCharacter) }
            )
            deferredResult.awaitAll()
        }

    }

    LaunchedEffect(Unit){
        delay(10000L)
        manipulateActivityUserToScreen(context, true)
    }

    DisposableEffect(Unit) {
        onDispose {
            manipulateActivityUserToScreen(context, true)
        }
    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreenPr(
    castMainPicture:String,
    descriptionOfCast:String,
    dateBirthDayCast:String,
    allPhotosOfCast:List<String>,
    moviesRelateWithCast:List<String>,
    paddingOfContent:Dp
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp)
                .background(MaterialTheme.colors.onPrimary)
                .verticalScroll(rememberScrollState())
        ) {
            VideoCharacter()
            SmallSpacer()
            BioCharacter(
                description = descriptionOfCast,
                imageUrl = castMainPicture,
                date = dateBirthDayCast,
                maxLines = 5,
                paddingOfContent = paddingOfContent
            )
            SmallSpacer()
            PhotosSection(
                allPhoto = allPhotosOfCast,
                paddingOfContent = paddingOfContent
            )
            SmallSpacer()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = paddingOfContent)
            ) {
                Text(
                    text = "See All Photos",
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "arrow right",
                    tint = MaterialTheme.colors.onSecondary
                )
            }
            SmallSpacer()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = paddingOfContent)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Contact Info",
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.onSecondary
                    )
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.call),
                            contentDescription = "call",
                            tint = MaterialTheme.colors.onSecondary
                        )
                        Text(
                            text = "  View agent, publicist, legal, IMDbPro",
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onSecondary
                        )
                    }
                }
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "arrow right",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    tint = MaterialTheme.colors.onSecondary
                )
            }
            SmallSpacer()
            Filmography(allPhotos = moviesRelateWithCast, paddingOfContent = paddingOfContent)
        }
    }
}