package com.phuong.notifications.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.phuong.notifications.databinding.ItemNotificationBinding
import com.phuong.notifications.ui.ItemNotification

class NotificationAdapter :  ListAdapter<ItemNotification,ViewHolder>(diffUtilNoti){

    inner class NotificationViewHolder(private val binding: ItemNotificationBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = holder.itemView as ItemNotificationBinding
        item.item = getItem(position)
    }

    companion object{
        val diffUtilNoti = object : DiffUtil.ItemCallback<ItemNotification>(){
            override fun areItemsTheSame(
                oldItem: ItemNotification,
                newItem: ItemNotification
            ): Boolean = oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: ItemNotification,
                newItem: ItemNotification
            ): Boolean = oldItem == newItem

        }
    }
}