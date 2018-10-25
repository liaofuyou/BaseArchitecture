package me.ajax.basearchitecture.ui.news.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import me.ajax.basearchitecture.R
import me.ajax.basearchitecture.ui.base.viewmodel.BaseActivity
import me.ajax.basearchitecture.ui.news.viewmodel.NewsViewModel
import me.ajax.basearchitecture.utils.Utils

class NewsActivity : BaseActivity() {

    private lateinit var newsViewModel: NewsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsAdapter = NewsAdapter()

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = newsAdapter

        newsViewModel = Utils.createViewModel(this, NewsViewModel::class.java)
        newsViewModel.liveData.observe(this, Observer {

            newsAdapter.newses = it!!
            newsAdapter.notifyDataSetChanged()
        })
        newsViewModel.getNewsList()
    }
}
