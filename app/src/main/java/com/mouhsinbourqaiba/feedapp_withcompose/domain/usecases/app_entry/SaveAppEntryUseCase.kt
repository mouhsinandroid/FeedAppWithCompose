package com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.app_entry

import com.mouhsinbourqaiba.feedapp_withcompose.domain.manager.LocalUserManager

class SaveAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}