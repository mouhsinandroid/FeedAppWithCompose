package com.mouhsinbourqaiba.feedapp_withcompose.data.remote

import com.mouhsinbourqaiba.feedapp_withcompose.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    fun getNews(
        @Query("page") page : Int,
        @Query("sources") source: String,
        @Query("apiKey") apiKey: String
    ) : NewsResponse

}