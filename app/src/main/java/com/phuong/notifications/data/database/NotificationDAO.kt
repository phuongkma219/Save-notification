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
     fun insertData(notificationEntity: NotificationEntity)

    @Query("SELECT * FROM notification_data")
     fun getALlNotification() : List<NotificationEntity>

    @Query("DELETE FROM notification_data WHERE id = :id")
     fun delete(id : String)
}