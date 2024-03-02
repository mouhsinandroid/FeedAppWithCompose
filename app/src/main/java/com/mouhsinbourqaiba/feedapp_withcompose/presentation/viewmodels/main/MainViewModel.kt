package com.mouhsinbourqaiba.feedapp_withcompose.presentation.viewmodels.main


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.AppEntryUsesCases
import com.mouhsinbourqaiba.feedapp_withcompose.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUsesCases: AppEntryUsesCases
): ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)

    init {
        viewModelScope.launch {
            appEntryUsesCases.readAppEntryUseCase().collect { shouldStartFormHomeScreen ->
                startDestination = if(shouldStartFormHomeScreen) {
                    Route.NewsNavigation.route
                } else {
                    Route.AppStartNavigation.route
                }
                delay(300)
                splashCondition = false
            }
        }

    }

}