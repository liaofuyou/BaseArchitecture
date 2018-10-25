package me.ajax.basearchitecture.ui.main.viewmodel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import me.ajax.basearchitecture.R
import me.ajax.basearchitecture.ui.news.view.NewsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({ startActivity(Intent(this, NewsActivity::class.java)) }, 1000)

    }
}
