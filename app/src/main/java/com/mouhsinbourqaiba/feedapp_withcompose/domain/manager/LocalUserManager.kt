package com.mouhsinbourqaiba.feedapp_withcompose.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    suspend fun saveAppEntry()
    suspend fun readAppEntry(): Flow<Boolean>
}