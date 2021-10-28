package com.happymoonday.challengesforheymoon.presentation.ui.home

import android.os.Bundle
import com.happymoonday.challengesforheymoon.databinding.ActivityHomeBinding
import com.happymoonday.challengesforheymoon.presentation.base.BaseActivity

class HomeActivity : BaseActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}