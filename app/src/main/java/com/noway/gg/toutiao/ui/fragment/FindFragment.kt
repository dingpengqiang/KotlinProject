package com.noway.gg.toutiao.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.base.BaseFragment
import com.noway.gg.toutiao.model.Search
import com.noway.gg.toutiao.presenter.FindPresenter
import com.noway.gg.toutiao.showToast
import com.noway.gg.toutiao.ui.activity.SearchActivity
import com.noway.gg.toutiao.ui.interfaces.IFindFragment
import kotlinx.android.synthetic.main.fragment_find.*

/**
 * 包名:    com.noway.gg.toutiao.ui
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/12
 * 版本:    V-1.0.0
 */

class FindFragment : BaseFragment(), IFindFragment {



    val TAG:String = FindFragment::class.java.simpleName

    private val mPresenter by lazy {
       FindPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // 布局导入
        layout = inflater.inflate(R.layout.fragment_find, container, false)
        return layout
    }
    override fun initTitle() {

    }

    override fun initView() {
        searchView.isFocusable=true
        searchView.isFocusableInTouchMode = true
        searchView.requestFocus()

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener, android.support.v7.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {


                if (p0 != null) {
                    requestData(p0)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                return false
            }


        })

    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun initData() {



    }

    override fun setStatusBar() {

    }

    override fun finishRefresh() {

    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    override fun requestData(keyword:String) {
       mPresenter.getSearch(context!!,keyword)

    }

    override fun getDataSuccess(search: Search) {
        var intent = Intent(context,SearchActivity::class.java)
        intent.putExtra("" +
                "search",search)
        startActivity(intent)
    }
}