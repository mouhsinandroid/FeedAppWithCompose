package com.mouhsinbourqaiba.feedapp_withcompose.domain.repository

import androidx.paging.PagingData
import com.mouhsinbourqaiba.feedapp_withcompose.domain.models.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>) : Flow<PagingData<Article>>
}