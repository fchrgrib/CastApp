package com.example.technicaltestforinternshipatcampaign.presentation.ui.utils

import android.content.Context

fun isFirstTimeUserToScreen(context: Context):Boolean{
    val sharedPrefs = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    return sharedPrefs.getBoolean("isFirstTimeUserToScreen", true)
}
fun manipulateActivityUserToScreen(context : Context, boolean: Boolean) {
    val sharedPrefs = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    sharedPrefs.edit().putBoolean("isFirstTimeUserToScreen", boolean).apply()
}