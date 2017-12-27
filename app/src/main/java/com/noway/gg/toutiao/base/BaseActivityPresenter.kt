package com.noway.gg.toutiao.base

/**
 * 包名:    com.noway.gg.toutiao.base
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/21
 * 版本:    V-1.0.0
 */
class BaseActivityPresenter< T : IBaseActivityView> :ActivityPresenter<T> {


    private var mView : T? = null


    override fun attachView(view: T) {
        this.mView = view
    }

    override fun detachView() {
        this.mView = null
    }

    fun isViewAttached() :Boolean{

        return mView != null
    }

    fun getView() : T? {


        return mView
    }


}