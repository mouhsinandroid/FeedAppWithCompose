package com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.news

import androidx.paging.PagingData
import com.mouhsinbourqaiba.feedapp_withcompose.domain.models.Article
import com.mouhsinbourqaiba.feedapp_withcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(
    val repository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return repository.getNews(sources = sources)
    }
}