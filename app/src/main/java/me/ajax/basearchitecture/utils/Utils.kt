package me.ajax.basearchitecture.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity


//静态工具类
object Utils {

    fun <T : ViewModel?> createViewModel(activity: FragmentActivity, modelClass: Class<T>): T {
        val factory = ViewModelProviders.of(activity,
                ViewModelProvider.AndroidViewModelFactory(activity.application))
        return factory.get(modelClass)
    }

    fun <T : ViewModel?> createViewModel(fragment: Fragment, modelClass: Class<T>): T {
        val factory = ViewModelProviders.of(fragment,
                ViewModelProvider.AndroidViewModelFactory(fragment.activity!!.application))
        return factory.get(modelClass)
    }
}