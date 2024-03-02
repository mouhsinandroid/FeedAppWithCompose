package com.mouhsinbourqaiba.feedapp_withcompose.di

import android.app.Application
import com.mouhsinbourqaiba.feedapp_withcompose.data.manager.LocalUserManagerImpl
import com.mouhsinbourqaiba.feedapp_withcompose.domain.manager.LocalUserManager
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.AppEntryUsesCases
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.ReadAppEntryUseCase
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUserManager: LocalUserManager) = AppEntryUsesCases(
        readAppEntryUseCase = ReadAppEntryUseCase(localUserManager = localUserManager),
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserManager = localUserManager)
    )
}