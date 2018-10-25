package me.ajax.basearchitecture.net.api

import io.reactivex.Observable
import me.ajax.basearchitecture.ui.news.model.News
import retrofit2.http.GET



interface NewsApi {

    @GET("users/list")
    fun getNewses(): Observable<List<News>>
}