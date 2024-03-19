package com.mouhsinbourqaiba.feedapp_withcompose.di

import android.app.Application
import com.mouhsinbourqaiba.feedapp_withcompose.data.manager.LocalUserManagerImpl
import com.mouhsinbourqaiba.feedapp_withcompose.data.remote.NewsApi
import com.mouhsinbourqaiba.feedapp_withcompose.data.repository.NewsRepositoryImp
import com.mouhsinbourqaiba.feedapp_withcompose.domain.manager.LocalUserManager
import com.mouhsinbourqaiba.feedapp_withcompose.domain.repository.NewsRepository
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.app_entry.AppEntryUsesCases
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.app_entry.ReadAppEntryUseCase
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.app_entry.SaveAppEntryUseCase
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.news.GetNewsUseCase
import com.mouhsinbourqaiba.feedapp_withcompose.domain.usecases.news.NewsUseCase
import com.mouhsinbourqaiba.feedapp_withcompose.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi  {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewsRepositoryImp(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository) :NewsUseCase {
        return NewsUseCase(
            getNewsUseCase = GetNewsUseCase(newsRepository)
        )
    }
}