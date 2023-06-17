package com.example.technicaltestforinternshipatcampaign.presentation.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SmallSpacer() {
    Spacer(modifier = Modifier.padding(vertical = 5.dp))
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(3.dp)
        .background(MaterialTheme.colors.background))
    Spacer(modifier = Modifier.padding(vertical = 5.dp))
}