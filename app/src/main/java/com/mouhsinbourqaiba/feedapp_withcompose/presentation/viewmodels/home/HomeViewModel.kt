package com.mouhsinbourqaiba.feedapp_withcompose.presentation.viewmodels.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
)  : ViewModel() {
    val news = newsUseCase.getNewsUseCase(
        sources = listOf("abc-news", "abc-news", "al-jazeera-english")
    ).cachedIn(viewModelScope)
}