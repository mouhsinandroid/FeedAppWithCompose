package com.mouhsinbourqaiba.feedapp_withcompose.data.remote.dto

import com.mouhsinbourqaiba.feedapp_withcompose.domain.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)