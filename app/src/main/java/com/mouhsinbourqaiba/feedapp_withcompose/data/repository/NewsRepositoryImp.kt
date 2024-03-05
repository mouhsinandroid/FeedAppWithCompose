package com.mouhsinbourqaiba.feedapp_withcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mouhsinbourqaiba.feedapp_withcompose.data.remote.NewsApi
import com.mouhsinbourqaiba.feedapp_withcompose.data.remote.NewsPagingSource
import com.mouhsinbourqaiba.feedapp_withcompose.domain.models.Article
import com.mouhsinbourqaiba.feedapp_withcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(
    private val newsApi: NewsApi
): NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}