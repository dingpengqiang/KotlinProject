package com.noway.gg.toutiao.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.lang.ref.WeakReference

/**
 * 包名:    com.noway.gg.toutiao.base
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/12
 * 版本:    V-1.0.0
 */
abstract class BaseActivity : AppCompatActivity(){

    /**当前Activity的弱引用，防止内存泄露**/
    private var wContent: WeakReference<Activity>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initThis()
        initBack()
        initTitle()
        initView()
        initPresenter()
        initData()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)

        //TODO  初始化View前设置状态栏颜色
        setStatusBar()
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        //TODO  实现淡入淡出效果
//        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

        //TODO  实现左进右出效果
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
    }
    /**
     * 初始化当前栈
     */
    private fun initThis(){
        //将当前Activity压入栈
        wContent = WeakReference<Activity>(this)
    }

    /**
     * 初始化返回Activity
     */
    private fun initBack(){

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