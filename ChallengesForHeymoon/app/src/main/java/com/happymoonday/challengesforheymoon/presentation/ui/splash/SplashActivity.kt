package com.happymoonday.challengesforheymoon.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.happymoonday.challengesforheymoon.R
import com.happymoonday.challengesforheymoon.presentation.base.BaseActivity
import com.happymoonday.challengesforheymoon.presentation.ui.home.HomeActivity

class SplashActivity : BaseActivity() {

    companion object {
        private const val SPLASH_DELAY : Long = 1500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        showProgress()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            hideProgress()
        }, SPLASH_DELAY)
    }

}