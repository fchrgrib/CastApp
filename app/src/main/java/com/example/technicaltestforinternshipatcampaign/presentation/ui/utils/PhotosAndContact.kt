package com.example.technicaltestforinternshipatcampaign.presentation.ui.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.technicaltestforinternshipatcampaign.R


@Composable
fun PhotosSection(allPhoto:List<String>,paddingOfContent:Dp) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = paddingOfContent)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Photos",
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

        LazyRow {
            items(allPhoto){
                PhotoOfCast(imageUrl = it)
            }
        }
    }
}

@Composable
fun PhotoOfCast(
    imageUrl:String
) {
    AsyncImage(
        model = imageUrl,
        contentDescription ="profile",
        modifier = Modifier
            .width(90.dp)
            .height(120.dp)
            .padding(end = 1.dp),
        contentScale = ContentScale.Crop
    )
}