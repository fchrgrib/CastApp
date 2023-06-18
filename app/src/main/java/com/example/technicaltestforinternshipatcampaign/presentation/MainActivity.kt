package com.example.technicaltestforinternshipatcampaign.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.technicaltestforinternshipatcampaign.presentation.ui.MainScreen
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.CastsAppTheme
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity:AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CastsAppTheme {
                supportActionBar?.hide()
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(mainViewModel = viewModel)
            }
        }
    }
}