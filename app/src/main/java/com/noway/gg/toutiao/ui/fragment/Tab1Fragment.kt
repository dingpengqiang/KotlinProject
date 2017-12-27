package com.noway.gg.toutiao.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.adapter.NewsAdapter
import com.noway.gg.toutiao.base.BaseFragment
import com.noway.gg.toutiao.model.Channels
import com.noway.gg.toutiao.model.NewsList
import com.noway.gg.toutiao.presenter.Tab1Presenter
import com.noway.gg.toutiao.showToast
import com.noway.gg.toutiao.ui.activity.Html5Activity
import com.noway.gg.toutiao.ui.interfaces.ITab1Fragment
import kotlinx.android.synthetic.main.fragment_tab1.*

/**
 * 包名:    com.noway.gg.toutiao.ui
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/12
 * 版本:    V-1.0.0
 */

class Tab1Fragment : BaseFragment(), ITab1Fragment {



    val TAG: String = Tab1Fragment::class.java.simpleName

    var mPresenter: Tab1Presenter? = null
    var mAdapter: NewsAdapter? = null

    var mChannel: String? = null

    private var isPrepared: Boolean = false//初始化是否完成
    private var isHasLoadedOnce: Boolean = false    //是否已经有过一次加载数据

    private var lisenter : FabVISIBLE? = null

    fun setLisenter(lisenter :FabVISIBLE){
        this.lisenter = lisenter
    }

    private var page = 1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isPrepared = true
        // 布局导入
        layout = inflater.inflate(R.layout.fragment_tab1, container, false)
        return layout
    }

    /**
     * 伴生对象
     */
    companion object {
        fun getInstance(): Tab1Fragment {
            val fragment = Tab1Fragment()
            return fragment
        }
    }

    /**
     * 延迟初始化
     */
    private val linearLayoutManager by lazy {
        LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }
    override fun initTitle() {

    }

    override fun initView() {

        var bundle = arguments
        mChannel = bundle!!["channel"] as String?

        recycler_view.layoutManager = linearLayoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()

        mAdapter = NewsAdapter(R.layout.item_news, null)
        recycler_view.adapter = mAdapter

        recycler_view.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                var intent = Intent(context,Html5Activity::class.java)
                var newsList = adapter.getItem(position) as NewsList
                intent.putExtra("url", newsList.weburl)
                startActivity(intent)

            }
        })
        recycler_view.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)


                var firstItem = linearLayoutManager.findFirstVisibleItemPosition()
                if (firstItem == 0){
                    lisenter?.setMainBtmVISIBLE(true)
                }else{
                    lisenter?.setMainBtmVISIBLE(false)
                }


                var lastItem = linearLayoutManager.findLastVisibleItemPosition()

                if (lastItem+1 == mAdapter?.data?.size){
                    lisenter?.setFabVISIBLE(false)
                }else{
                    lisenter?.setFabVISIBLE(true)
                }

            }
        })


        mAdapter?.setOnLoadMoreListener({

            page ++
            getData()

        },recycler_view)


    }

    override fun initPresenter() {
        mPresenter = Tab1Presenter()
        mPresenter?.attachView(this)
    }

    override fun initData() {

    }

    fun getData() {
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
        mPresenter?.getNews(context!!, this.mChannel!!, (page * 10).toString(), "0")
    }

    override fun getDataSuccess(channels: Channels) {

        isHasLoadedOnce = true

        var result = channels.result
        var list = result?.list
        if (mAdapter?.isLoadMoreEnable!!){
            mAdapter?.addData(list!!)
            mAdapter?.loadMoreComplete()
            if (list?.size!! < 10){
                mAdapter?.loadMoreEnd()
            }
        }else{
            mAdapter?.setNewData(list)
            mAdapter?.disableLoadMoreIfNotFullPage(recycler_view)
        }


    }


    interface FabVISIBLE{
        fun setFabVISIBLE(isVISIBLE :Boolean)
        fun setMainBtmVISIBLE(isVISIBLE :Boolean)

    }

}