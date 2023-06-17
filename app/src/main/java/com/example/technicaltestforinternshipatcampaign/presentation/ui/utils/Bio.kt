package com.example.technicaltestforinternshipatcampaign.presentation.ui.utils

import android.R.attr.width
import android.R.color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.technicaltestforinternshipatcampaign.R
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.CastsAppTheme
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.Shapes
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.interFont
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
    val dateParse = LocalDate.parse(date)

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

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun testing() {
    CastsAppTheme {
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
            ) {
                VideoCharacter()
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(MaterialTheme.colors.background))
                BioCharacter(
                    description = stringResource(R.string.rachel_description),
                    imageUrl = "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
                    date = "1979-02-01",
                    maxLines = 5,
                    paddingOfContent = 9.dp
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(MaterialTheme.colors.background))
            }
        }
    }

}