package com.mouhsinbourqaiba.feedapp_withcompose.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.mouhsinbourqaiba.feedapp_withcompose.R



val Roboto = FontFamily(
    Font(R.font.roboto_black),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val NotoSerif = FontFamily(
    Font(R.font.notoserif_variable),
    Font(R.font.notoserif_variable, FontWeight.Bold)
)

val AppTypography = Typography(
    defaultFontFamily = Roboto,
    h1 = TextStyle(
        fontFamily = NotoSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = NotoSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    // Since h2 was causing issues, ensure you're using an existing parameter. If h2 is not recognized, it could be due to version issues or a typo. Here, we proceed without it or ensure it's correctly defined according to your library version.
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
    // Add other styles as needed
)


