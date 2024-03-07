package com.phuong.notifications.data

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.ByteArrayOutputStream

@Entity("notification_data")
data class NotificationEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val appPackage : String,
    val iconImage : ByteArray,
    val title : String,
    val content : String,
    val date : Long
)
fun convertDrawableToByteArray(drawable: Drawable?): ByteArray {
    return if (drawable != null){
        val bitmap = (drawable as BitmapDrawable).bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.toByteArray()
    }
    else{
        byteArrayOf()
    }
}
