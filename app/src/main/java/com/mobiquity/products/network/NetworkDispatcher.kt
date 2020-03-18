package com.mobiquity.products.network

import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * NetworkDispatcher class for setup retrofit setting
 */
@Singleton
class NetworkDispatcher @Inject constructor(){

    private val TIMEOUT_CONNECT = 30
    private val TIMEOUT_READ = 30

    private val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    private val gson = Gson()
    private var retrofit: Retrofit? = null

    init {
        okHttpBuilder.addInterceptor (logger)
        okHttpBuilder.connectTimeout(TIMEOUT_CONNECT.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(TIMEOUT_READ.toLong(), TimeUnit.SECONDS)
    }

    /**
     * @param baseUrl API base url path
     * @param serviceClass generic API service types
     * @return retrofit instance of generic API service types
     */
    fun <S> createService(serviceClass: Class<S>, baseUrl: String): S {
        val client = okHttpBuilder.build()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit!!.create(serviceClass)
    }

    private val logger: HttpLoggingInterceptor
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                loggingInterceptor.apply { loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS }.level = HttpLoggingInterceptor.Level.BODY
            }
            return loggingInterceptor
        }
}