package com.example.technicaltestforinternshipatcampaign.presentation.ui.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.CastsAppTheme


@Composable
fun Filmography(
    allPhotos:List<String>,
    paddingOfContent:Dp
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = paddingOfContent)
    ) {
        Text(
            text = "Filmography",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.padding(vertical = 2.dp))
        Text(
            text = "Known For",
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.padding(vertical = 1.dp))
        LazyRow{
            items(allPhotos){
                Film(film = it)
            }
        }
    }
}

@Composable
fun Film(film:String) {
    AsyncImage(
        model = film,
        contentDescription ="profile",
        modifier = Modifier
            .width(100.dp)
            .height(130.dp)
            .padding(end = 1.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun FilmsPrev() {
    val allPhotos = listOf(
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
        "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg"
    )
    CastsAppTheme {
        Filmography(allPhotos = allPhotos, paddingOfContent = 9.dp)
    }

}