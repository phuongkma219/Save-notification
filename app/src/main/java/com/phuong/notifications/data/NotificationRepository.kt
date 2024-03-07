package com.phuong.notifications.data

import kotlinx.coroutines.flow.Flow

interface NotificationRepository {
    suspend fun saveNotification(notificationEntity: NotificationEntity)
    suspend fun getALlNotification() : Flow<List<NotificationEntity>>
    suspend fun deleteNotification(id : String)
}