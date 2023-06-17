package com.example.technicaltestforinternshipatcampaign.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.technicaltestforinternshipatcampaign.presentation.ui.theme.CastsAppTheme
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.MainViewModel
import com.example.technicaltestforinternshipatcampaign.presentation.viewmodels.models.CastCreditsResult
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CastsAppTheme {

                val viewModel = hiltViewModel<MainViewModel>()
                viewModel.getPeople("2")

                val result = viewModel.castCreditResult.collectAsState().value

                if (result!=null && result is CastCreditsResult.CastCreditsRes){
                    Log.d("ini",result.castCredits.size.toString())
                }
            }
        }
    }
}