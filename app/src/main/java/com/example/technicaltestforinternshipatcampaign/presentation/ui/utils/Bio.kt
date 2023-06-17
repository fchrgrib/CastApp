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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.Shapes
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.interFont
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BioCharacter(
    name:String,
    description:String,
    maxLines:Int,
    imageUrl:String,
    date:String
) {
    val dateParse = LocalDate.parse(date)

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(9.dp)) {
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
                        style = TextStyle(
                            fontFamily = interFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = Modifier.padding(vertical = 3.dp))
                    Row {
                        Text(
                            text = "Born: ",
                            style = TextStyle(
                                fontFamily = interFont,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            ),
                            color = MaterialTheme.colors.onSecondary
                        )
                        Text(
                            text = "${
                                dateParse.month.toString().toLowerCase().capitalize()
                            } ${dateParse.dayOfMonth}, ${dateParse.year}",
                            style = TextStyle(
                                fontFamily = interFont,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp
                            ),
                            color = MaterialTheme.colors.onSecondary
                        )
                    }
                }
            }
        }

    }

}
private fun String.lineCount(): Int = this.count { it == '\n' } + 1

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun testing() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFdcdee0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .background(Color.White)
        ) {
            VideoCharacter()
            Box(modifier = Modifier.fillMaxWidth().height(3.dp).background(Color(0xFFdcdee0)))
            BioCharacter(
                name = "fahrian",
                description = "Rachelle Lefevre was born in Canada. While waiting tables, Lefevre was discovered by a Canadian film producer who, in turn, helped the aspiring...",
                imageUrl = "https://static.tvmaze.com/uploads/images/medium_portrait/82/207417.jpg",
                date = "1979-02-01",
                maxLines = 5
            )
            Box(modifier = Modifier.fillMaxWidth().height(3.dp).background(Color(0xFFdcdee0)))
        }
    }
}