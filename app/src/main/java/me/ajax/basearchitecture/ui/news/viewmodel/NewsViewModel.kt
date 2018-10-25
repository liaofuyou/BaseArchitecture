package me.ajax.basearchitecture.ui.news.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import me.ajax.basearchitecture.net.RestClient
import me.ajax.basearchitecture.ui.news.model.News

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val disposables = CompositeDisposable()

    //生命周期观察的数据
    val liveData: MutableLiveData<List<News>> = MutableLiveData()

    fun getNewsList() {

        RestClient.newsApi().getNewses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    this.liveData.value = it
                }, { error ->
                    Log.e("TAG", "Unable to get username", error)
                })
    }


    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}