package com.mouhsinbourqaiba.feedapp_withcompose.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.mouhsinbourqaiba.feedapp_withcompose.domain.models.Article
import com.mouhsinbourqaiba.feedapp_withcompose.utils.Dimens.ExtraSmallPadding
import com.mouhsinbourqaiba.feedapp_withcompose.utils.Dimens.MediumPadding1

@Composable
fun ArticlesList(
    modifier: Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(articles = articles)
    if (handlePagingResult) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding)
            ) {
            items(count = articles.itemCount) {
                articles[it]?.let { article ->
                    ArticleCard(article = article, onClick = { onClick(article) })
                }
            }

        }
    }

}

@Composable
fun handlePagingResult(
    articles: LazyPagingItems<Article>
): Boolean {

    val loadStat = articles.loadState
    val error = when {
        loadStat.refresh is LoadState.Error -> loadStat.refresh as LoadState
        loadStat.prepend is LoadState.Error -> loadStat.prepend as LoadState
        loadStat.append is LoadState.Error -> loadStat.append as LoadState
        else -> null
    }

    return when {
        loadStat.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen()
            false
        }

        else -> {
            true
        }
    }

}

@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}