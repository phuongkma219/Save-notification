package com.phuong.notifications.data.di

import android.content.Context
import com.phuong.notifications.data.NotificationRepository
import com.phuong.notifications.data.NotificationRepositoryImpl
import com.phuong.notifications.data.database.AppDatabase
import com.phuong.notifications.data.database.NotificationDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providerNotificationDAO(appDatabase: AppDatabase): NotificationDAO {
        return appDatabase.notificationDAO()
    }

    @Provides
    @Singleton
    fun providerDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.invoke(appContext)
    }

    @Provides
    @Singleton
    fun providerNotificationRepository(notificationDAO: NotificationDAO) : NotificationRepository = NotificationRepositoryImpl(notificationDAO)
}