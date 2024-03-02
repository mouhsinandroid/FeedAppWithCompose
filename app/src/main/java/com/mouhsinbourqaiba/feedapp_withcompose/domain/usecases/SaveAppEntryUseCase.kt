package com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases

import com.mouhsinbourqaiba.feedapp_withcompose.domain.manager.LocalUserManager

class SaveAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}