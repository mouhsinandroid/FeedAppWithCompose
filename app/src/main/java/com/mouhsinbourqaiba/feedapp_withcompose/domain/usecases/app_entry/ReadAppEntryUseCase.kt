package com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.app_entry

import com.mouhsinbourqaiba.feedapp_withcompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}