package com.phuong.notifications.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.phuong.notifications.data.NotificationEntity

@Database(entities = [NotificationEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notificationDAO(): NotificationDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private const val  DATABASE_NAME = "phuong.db"

        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, DATABASE_NAME)
            .build()
    }

}