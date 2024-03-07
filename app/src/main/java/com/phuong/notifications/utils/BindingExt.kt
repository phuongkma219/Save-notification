package com.phuong.notifications.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.Date

@BindingAdapter("convertTime")
fun TextView.convertTime(time : Long){
    val date = Date(time)
    val format = SimpleDateFormat("HH:mm a")
    this.text = format.format(date)
}