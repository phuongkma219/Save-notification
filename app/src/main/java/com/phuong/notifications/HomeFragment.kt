package com.phuong.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    private lateinit var binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layoutResId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}