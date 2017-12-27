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
interface ActivityPresenter<V : IBaseActivityView>{

     fun attachView(view: V)

     fun detachView()
}
