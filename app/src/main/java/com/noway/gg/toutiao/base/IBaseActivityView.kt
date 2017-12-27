package com.noway.gg.toutiao.base

import com.trello.rxlifecycle2.android.ActivityEvent


/**
 * 包名:    com.noway.gg.toutiao.base
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/21
 * 版本:    V-1.0.0
 */
interface IBaseActivityView {

    fun finishRefresh()

    fun showMessage(message :String)

//    fun <T> bindUntilEvent(event : ActivityEvent) : Observable.Transformer<T, T>



}