package com.noway.gg.toutiao

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * 包名:    com.noway.gg.toutiao
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/18
 * 版本:    V-1.0.0
 */


val APPKEY = "726ba444c8f8ed0d8e8ba45ae840595e"


fun Fragment.showToast(content: String): Toast {
    val toast = Toast.makeText(this.activity?.applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun Context.showToast(content: String): Toast {
    val toast = Toast.makeText(this.applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}