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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun mainScreenPrev() {
    val allPhotos = listOf(
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg"
    )
    val scrollState = rememberScrollState()
    CastsAppTheme {
        MainScreen(
            castMainPicture = "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
            descriptionOfCast = stringResource(id = R.string.rachel_description),
            dateBirthDayCast = "1979-02-01",
            allPhotosOfCast = allPhotos,
            paddingOfContent = 9.dp,
            moviesRelateWithCast = allPhotos
        )
    }
}