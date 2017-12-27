package com.noway.gg.toutiao.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.base.BaseFragment

/**
 * 包名:    com.noway.gg.toutiao.ui
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/12
 * 版本:    V-1.0.0
 */

class OtherFragment : BaseFragment(){

    val TAG:String = OtherFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // 布局导入
        layout = inflater.inflate(R.layout.fragment_other ,container, false)
        return layout
    }
    override fun initTitle() {

    }

    override fun initView() {

    }

    override fun initPresenter() {

    }

    override fun initData() {

    }

    override fun setStatusBar() {

    }

}