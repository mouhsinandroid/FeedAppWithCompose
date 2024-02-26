package com.mouhsinbourqaiba.feedapp_withcompose.ui.theme


import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.mouhsinbourqaiba.feedapp_withcompose.R
import androidx.compose.material3.Typography


val Roboto = FontFamily(
    Font(R.font.roboto_black),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val NotoSerif = FontFamily(
    Font(R.font.notoserif_variable),
    Font(R.font.notoserif_variable, FontWeight.Bold)
)

val Typography = Typography(
    displaySmall = TextStyle(
        fontSize = 24.sp,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        lineHeight = 36.sp,
    ),
    displayMedium = TextStyle(
        fontSize = 32.sp,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        lineHeight = 48.sp,
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        lineHeight = 21.sp,
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
    ),
    labelSmall = TextStyle(
        fontSize = 13.sp,
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        lineHeight = 19.sp,
    ),
)