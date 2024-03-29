package com.phuong.notifications.data

import com.phuong.notifications.data.database.NotificationDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject


class NotificationRepositoryImpl @Inject constructor(private val notificationDAO: NotificationDAO): NotificationRepository {
    override suspend fun saveNotification(notificationEntity: NotificationEntity) = withContext(Dispatchers.IO){
        notificationDAO.insertData(notificationEntity)
    }

    override suspend fun getALlNotification(): Flow<List<NotificationEntity>> {
        return flow { emit(notificationDAO.getALlNotification() ) }.flowOn(Dispatchers.IO)
    }

    override suspend fun deleteNotification(id : String) = withContext(Dispatchers.IO){
        notificationDAO.delete(id)
    }
}