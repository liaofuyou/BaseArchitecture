package me.ajax.basearchitecture.net

import me.ajax.basearchitecture.net.api.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

enum class RestClient {
    INSTANCE;

    private var newsApi: NewsApi

    init {

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        /*
         * 实例化Service们
         */

        newsApi = retrofit.create(NewsApi::class.java)
    }


    companion object {
        fun newsApi(): NewsApi {
            return INSTANCE.newsApi
        }
    }


}