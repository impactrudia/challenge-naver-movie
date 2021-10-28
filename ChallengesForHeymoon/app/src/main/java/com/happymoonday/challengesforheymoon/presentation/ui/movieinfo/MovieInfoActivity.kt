package com.happymoonday.challengesforheymoon.presentation.ui.movieinfo

import android.os.Bundle
import android.webkit.WebViewClient
import com.happymoonday.challengesforheymoon.databinding.ActivityMovieInfoBinding
import com.happymoonday.challengesforheymoon.presentation.base.BaseActivity

class MovieInfoActivity : BaseActivity() {

    private lateinit var binding : ActivityMovieInfoBinding

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
                loadUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=187310")//TODO CHANGE
            }
            btnRedo.setOnClickListener {
                if(webView.canGoBack()){
                    webView.goBack()
                }else {
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