package com.phuong.notifications.data.database

import android.app.Notification
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.phuong.notifications.data.NotificationEntity

@Dao
interface NotificationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(notificationEntity: NotificationEntity)

    @Query("SELECT * FROM NOTIFICATION_DATA")
    suspend fun getALlNotification() : List<NotificationEntity>

    @Delete
    suspend fun delete(notificationEntity: NotificationEntity)
}