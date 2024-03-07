package com.phuong.notifications.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.phuong.notifications.R
import com.phuong.notifications.data.NotificationEntity
import com.phuong.notifications.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        setUpData()
        checkPermission()
        return binding.root
    }

    private fun setUpData() {
        checkPermission()
        binding.btnAdd.setOnClickListener {
            val notificationEntity = NotificationEntity(
                appPackage = count.toString(),
                iconImage = byteArrayOf(),
                title = "Phuong_${count}",
                content = "123123",
                date = 0
            )
            viewModel.saveNotification(notificationEntity)
        }
        binding.btnAscending.setOnClickListener {
            count += 1
        }
        binding.btnGet.setOnClickListener {
            viewModel.getListNotification()
        }
    }

    private fun checkPermission(){
        if (!hasAccessGranted()){
            val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
            activity?.startActivity(intent)
        }
    }
    private fun hasAccessGranted(): Boolean {
        val contentResolver = binding.root.context.contentResolver
        val enabledNotificationListeners = Settings.Secure.getString(contentResolver, "enabled_notification_listeners")
        val packageName = binding.root.context.packageName
        return !(enabledNotificationListeners == null || !enabledNotificationListeners.contains(packageName))
    }

}