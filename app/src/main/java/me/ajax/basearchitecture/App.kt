package me.ajax.basearchitecture

import android.app.Application
import android.util.Log

class App : Application() {

    val instance: App = this

    override fun onCreate() {
        super.onCreate()

        Log.i("App", "onCreate")
    }
}
