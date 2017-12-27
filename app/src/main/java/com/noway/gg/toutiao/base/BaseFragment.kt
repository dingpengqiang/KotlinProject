package com.noway.gg.toutiao.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 包名:    com.noway.gg.toutiao.base
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/12
 * 版本:    V-1.0.0
 */
abstract class BaseFragment : Fragment(){

    // Fragment的View
    protected var layout: View? = null



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        initTitle()
        initPresenter()
        initView()
        initData()
    }

    /**
     * 初始化标题
     */
    protected abstract fun initTitle()

    /**
     * 初始化View
     */
    protected abstract fun initView()

    /**
     * 初始化P层
     */
    protected abstract fun initPresenter()

    /**
     * 初始化数据
     */
    protected abstract fun initData()
    /**
     * 设置状态栏
     */
    protected abstract fun setStatusBar()
}