package com.noway.gg.toutiao.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.flexbox.*

import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.adapter.HotKeywordsAdapter
import com.noway.gg.toutiao.base.BaseActivity
import com.noway.gg.toutiao.model.Search
import com.noway.gg.toutiao.ui.fragment.Tab1Fragment
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity() {

    private val mHotKeywordsAdapter by lazy {
        HotKeywordsAdapter(R.layout.item_flow_text,null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_search)

        super.onCreate(savedInstanceState)
    }

    override fun initTitle() {

    }

    override fun initView() {

        var search = intent.getSerializableExtra("search") as Search

        var flexBoxLayoutManager = FlexboxLayoutManager(this)
        flexBoxLayoutManager.flexWrap = FlexWrap.WRAP      //按正常方向换行
        flexBoxLayoutManager.flexDirection = FlexDirection.ROW   //主轴为水平方向，起点在左端
        flexBoxLayoutManager.alignItems = AlignItems.CENTER    //定义项目在副轴轴上如何对齐
        flexBoxLayoutManager.justifyContent = JustifyContent.FLEX_START  //多个轴对齐方式



        recycler_view.layoutManager = flexBoxLayoutManager
        recycler_view.adapter = mHotKeywordsAdapter

        mHotKeywordsAdapter.setNewData(search.result?.list)


    }

    override fun initPresenter() {

    }

    override fun initData() {


    }

    override fun setStatusBar() {

    }
}
