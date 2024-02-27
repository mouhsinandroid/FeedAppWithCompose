package com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases

import com.mouhsinbourqaiba.feedapp_withcompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}