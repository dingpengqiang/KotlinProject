package com.noway.gg.toutiao.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.MenuItem
import com.noway.gg.toutiao.AppContext
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.base.BaseActivity
import com.noway.gg.toutiao.common.BottomNavigationViewHelper
import com.noway.gg.toutiao.showToast


import com.noway.gg.toutiao.ui.fragment.FindFragment
import com.noway.gg.toutiao.ui.fragment.HomeFragment
import com.noway.gg.toutiao.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var mShowFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main2)
        super.onCreate(savedInstanceState)

    }


    override fun initTitle() {

        // TODO("not implemented") To change body of created functions use File | Settings | File Templates.

        // 运行程序会抛NotImplementedError异常
        // Kotlin中某个函数的第一行添加TODO的话，那么很抱歉，它不会跳过，而是运行下一行代码。

        //解决办法 ：去掉即可
    }

    override fun initView() {

        initFragments()
        main_navigation.selectedItemId = R.id.menu_home
        main_navigation.setOnNavigationItemSelectedListener(this)
        //设置图标颜色，恢复图标本身颜色
        main_navigation.itemIconTintList = null
        /**
         * todo  通过反射修改ShiftingMode
         */
        BottomNavigationViewHelper.disableShiftMode(main_navigation)

    }

    override fun initPresenter() {

    }

    override fun initData() {

    }

    override fun setStatusBar() {

    }


    override fun onResume() {
        AppContext.me().refreshResources(this)
        super.onResume()
    }
    /**
     * 初始化碎片
     */
    private fun initFragments() {
        /**动态添加碎片**/

        mShowFragment = HomeFragment()

        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()

        transaction.add(R.id.main_frame, mShowFragment)

        //TODO  commitAllowingStateLoss  和 commit 区别
//        transaction.commitAllowingStateLoss()
        transaction.commit()
    }

    /**
     * 切换页面的封装
     *
     * @param tag 添加碎片的标记
     * @param clazz 添加碎片的class
     */
    private fun switchPages(tag: String, clazz: Class<out Fragment>): Unit {

        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        // 隐藏当前显示的页面
        transaction.hide(mShowFragment)
        //根据TAG去FragmentManager中进行查找碎片
        mShowFragment = manager.findFragmentByTag(tag)

        // 如果找到了，直接进行显示
        if (mShowFragment != null) {
            transaction.show(mShowFragment)
        } else {
            // 如果没找到，添加到容器中并且设置了一个标记

            //   使用反射进行了一个对象的实例化
            // TODO Kotlin reflection is not available
            mShowFragment = clazz.getConstructor().newInstance()

            transaction.add(R.id.main_frame, mShowFragment, tag)
        }

        transaction.commit()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home ->
                switchPages(HomeFragment::TAG.toString(),HomeFragment::class.java)
            R.id.menu_find ->
                switchPages(FindFragment::TAG.toString(),FindFragment::class.java)
            R.id.menu_mine ->
                switchPages(MineFragment::TAG.toString(),MineFragment::class.java)
        }
        return true
    }

    private  var mExitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
