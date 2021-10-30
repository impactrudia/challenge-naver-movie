package com.happymoonday.challengesforheymoon.presentation.ui.movieinfo

import android.os.Bundle
import android.webkit.WebViewClient
import com.happymoonday.challengesforheymoon.databinding.ActivityMovieInfoBinding
import com.happymoonday.challengesforheymoon.data.constants.Constants
import com.happymoonday.challengesforheymoon.presentation.base.BaseActivity

class MovieInfoActivity : BaseActivity() {

    private lateinit var binding: ActivityMovieInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            webView.apply {
                webViewClient = WebViewClient()

                settings.apply {
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    setSupportMultipleWindows(true)
                }
                val link = intent.getStringExtra(Constants.BUNDLE_LINK) ?: ""
                loadUrl(link)
            }
            btnRedo.setOnClickListener {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    super.onBackPressed()
                }
            }
            btnUndo.setOnClickListener {
                webView.goForward()
            }
            btnRefresh.setOnClickListener {
                webView.reload()
            }
            btnClose.setOnClickListener {
                finish()
            }
        }
    }

}