package com.noway.gg.toutiao

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import kotlin.properties.Delegates

//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃   神兽保佑
//    ┃　　　┃   代码无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
//
/**
 * 包名:    com.noway.gg.toutiao
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/12
 * 版本:    V-1.0.0
 */
class App : Application() {

    private val TAG = App ::class.java.simpleName


    private val isNight: Boolean = false


    override fun onCreate() {
        super.onCreate()

        initThemMode()

        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)

    }

    private fun initThemMode(){



    }
    private var mActivityLifecycleCallbacks = object :Application.ActivityLifecycleCallbacks{
        override fun onActivityCreated(activity: Activity?, p1: Bundle?) {
            Log.d(TAG, "onActivityCreated: " + activity!!.componentName.className)
        }

        override fun onActivityStarted(activity: Activity?) {

        }

        override fun onActivityResumed(activity: Activity?) {
            Log.d(TAG, "onActivityCreated: " + activity?.componentName?.className)
        }

        override fun onActivityPaused(activity: Activity?) {

        }

        override fun onActivityStopped(activity: Activity?) {

        }

        override fun onActivityDestroyed(activity: Activity?) {
            Log.d(TAG, "onActivityDestroyed: " + (activity?.componentName?.className ?: String))
        }

        override fun onActivitySaveInstanceState(activity: Activity?, bundle: Bundle?) {

        }

    }

}