package com.happymoonday.challengesforheymoon.presentation.ui.search

import android.os.Bundle
import com.happymoonday.challengesforheymoon.databinding.ActivitySearchBinding
import com.happymoonday.challengesforheymoon.presentation.base.BaseActivity

class SearchActivity : BaseActivity() {

    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}