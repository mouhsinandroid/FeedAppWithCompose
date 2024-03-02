package com.mouhsinbourqaiba.feedapp_withcompose.presentation.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.mouhsinbourqaiba.feedapp_withcompose.domain.models.Page
import androidx.compose.material3.Text
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mouhsinbourqaiba.feedapp_withcompose.R
import com.mouhsinbourqaiba.feedapp_withcompose.domain.models.pages
import com.mouhsinbourqaiba.feedapp_withcompose.ui.theme.FeedAppWithComposeTheme
import com.mouhsinbourqaiba.feedapp_withcompose.utils.Dimens.MediumPadding1
import com.mouhsinbourqaiba.feedapp_withcompose.utils.Dimens.MediumPadding2

@Composable
fun OnboardingPage(
    page: Page,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = modifier.height(MediumPadding1))

        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )

        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.title,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnboardingPagePreview() {
    FeedAppWithComposeTheme {
        OnboardingPage(pages[0], modifier = Modifier)
    }
}

