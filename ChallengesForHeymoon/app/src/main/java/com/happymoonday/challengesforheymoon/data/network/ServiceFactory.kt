package com.happymoonday.challengesforheymoon.data.network

import com.google.gson.GsonBuilder
import com.happymoonday.challengesforheymoon.BuildConfig
import com.happymoonday.challengesforheymoon.data.constants.NaverConstants
import io.reactivex.schedulers.Schedulers
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 네트워크 기본 상태 설정하는 모듈
 */
class ServiceFactory {
    companion object {
        const val HOST_URL = "https://openapi.naver.com"
        const val CLIENT_ID = NaverConstants.CLIENT_ID
        const val CLIENT_SECRET = NaverConstants.CLIENT_SECRET
    }

    private fun getAuthenticationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.addHeader(
                "X-Naver-Client-Id", CLIENT_ID
            )
            builder.addHeader(
                "X-Naver-Client-Secret", CLIENT_SECRET
            )
            return@Interceptor chain.proceed(builder.build())
        }
    }

    fun getOrganApi(): MovieRestApi = getDefaultOkHttpBuilder(HOST_URL)
        .run {
            val client = build()
            getDefaultRetrofitBuilder(HOST_URL)
                .client(client)
                .build()
                .create(MovieRestApi::class.java)
        }

    private fun getDefaultOkHttpBuilder(url: String) = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .apply {
            if (url.startsWith("https")) {
                // Make http client supports All TLS and Cipher suites
                val spec = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .allEnabledTlsVersions()
                    .allEnabledCipherSuites()
                    .supportsTlsExtensions(true)
                    .build()
                connectionSpecs(listOf(spec))
            }
            if (BuildConfig.DEBUG) {
                addInterceptor(getLoggingInterceptor())
            }
            addInterceptor(getAuthenticationInterceptor())
        }

    private fun getDefaultRetrofitBuilder(url: String) = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(GsonConverterFactory.create())

    private fun getLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}
