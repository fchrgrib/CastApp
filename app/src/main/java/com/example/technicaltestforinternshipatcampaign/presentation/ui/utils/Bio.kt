package com.example.technicaltestforinternshipatcampaign.presentation.ui.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BioCharacter(
    description:String,
    maxLines:Int,
    imageUrl:String,
    date:String,
    paddingOfContent:Dp
) {

    var dateParse:LocalDate? = null
    if (date!="")  dateParse = LocalDate.parse(date)

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingOfContent)) {
            Row {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(110.dp)
                )
                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                    Text(
                        text = description,
                        maxLines = maxLines,
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSecondary
                    )
                    Spacer(modifier = Modifier.padding(vertical = 3.dp))
                    Row {
                        Text(
                            text = "Born: ",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSecondary
                        )
                        if (dateParse!=null) {
                            Text(
                                text = "${
                                    dateParse.month.toString().toLowerCase().capitalize()
                                } ${dateParse.dayOfMonth}, ${dateParse.year}",
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.onSecondary
                            )
                        }
                    }
                }
            }
        }

    }

}