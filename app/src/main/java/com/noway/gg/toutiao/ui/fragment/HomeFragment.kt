package com.noway.gg.toutiao.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.adapter.ViewPagerAdapter
import com.noway.gg.toutiao.base.BaseFragment
import com.noway.gg.toutiao.model.ChannelList
import com.noway.gg.toutiao.presenter.HomePresenter
import com.noway.gg.toutiao.showToast
import com.noway.gg.toutiao.ui.activity.MainActivity
import com.noway.gg.toutiao.ui.interfaces.IHomeFragment
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 包名:    com.noway.gg.toutiao.ui
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/12
 * 版本:    V-1.0.0
 */

class HomeFragment : BaseFragment(), IHomeFragment, Tab1Fragment.FabVISIBLE {



    val TAG: String = HomeFragment::class.java.simpleName


    private var mainActivity: MainActivity? = null
    private var mPresenter: HomePresenter? = null
    private var fragmentList = arrayListOf<Tab1Fragment>()// ArrayList集合
    private var titleList = arrayListOf<String>()// ArrayList集合

    private var mAdapter: ViewPagerAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // 布局导入
        layout = inflater.inflate(R.layout.fragment_home, container, false)
        return layout
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity?
    }

    override fun initTitle() {

    }

    override fun initView() {

        fab.setOnClickListener {
            openSearchPage()
        }

    }

    override fun initPresenter() {
        mPresenter = HomePresenter()
        mPresenter!!.attachView(this)

    }

    override fun initData() {

        requestData()
    }

    override fun setStatusBar() {

    }


    override fun finishRefresh() {

    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    override fun requestData() {
        mPresenter?.getChannel(this.context!!)
    }

    override fun getDataSuccess(channelList: ChannelList) {

        titleList = channelList.result as ArrayList<String>

        if (titleList.size <= 0) {
            return
        }

        for (i in 0..(titleList.size - 1)) {// 表示[0,9]
            var tab1Fragment = Tab1Fragment.getInstance()
            var bundle = Bundle()
            var channel = titleList[i]
            bundle.putString("channel", channel)
            tab1Fragment.arguments = bundle

            tab1Fragment.setLisenter(this)

            fragmentList.add(tab1Fragment)
        }

        mAdapter = ViewPagerAdapter(childFragmentManager, fragmentList, titleList)
        viewpager.adapter = mAdapter


        tab_layout.setupWithViewPager(viewpager, true)

        //LinearLayout自带就有设置分割线的方法
        var linearLayout = tab_layout.getChildAt(0) as LinearLayout
        // 在所有子控件的中间显示分割线（还可能只显示顶部、尾部和不显示分割线）
        linearLayout.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE

        // 设置分割线的距离本身（LinearLayout）的内间距
        linearLayout.dividerPadding = 20
        // 设置分割线的样式
        linearLayout.dividerDrawable = ContextCompat.getDrawable(this.context!!, R.drawable.divider_vertical)



        /**
         * TODO  解决TabLayout + ViewPager + Fragment 的预加载问题
         *
         * 通过源码我们知道 最少预加载的页数是 1 (也就是左右各加载1页)，但这种体验感很差，不能实时的加载该页数据
         *
         * 解决办法：
         *          1.在每个Fragment里面定义一个方法：用来做请求数据
         *          2.通过ViewPager 滑动事件来加载数据
         *            ①:设置首次选中的tab页，并调用该页定义的请求数据的方法
         *            ②:在ViewPager的滑动事件里，通过选中的位置(position),去做网络请求
         *
         */

        //默认选中的tab 并加载该tab页的数据
        viewpager.currentItem = 1
        fragmentList[1].getData()
        viewpager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                fragmentList[position].getData()
            }

        })

    }

    override fun setFabVISIBLE(isVISIBLE: Boolean) {
        if (isVISIBLE) {
            fab.visibility = View.VISIBLE

        } else {
            fab.visibility = View.GONE

        }


    }

    override fun setMainBtmVISIBLE(isVISIBLE: Boolean) {
        if (isVISIBLE) {

            mainActivity?.main_navigation?.visibility = View.VISIBLE
            mainActivity?.blur_view?.visibility = View.VISIBLE
        } else {

            mainActivity?.main_navigation?.visibility = View.GONE
            mainActivity?.blur_view?.visibility = View.GONE
        }
    }

    private fun openSearchPage() {
        mainActivity?.main_navigation?.selectedItemId = R.id.menu_find
    }

}