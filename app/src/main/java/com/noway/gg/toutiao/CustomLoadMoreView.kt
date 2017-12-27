package com.noway.gg.toutiao

import com.chad.library.adapter.base.loadmore.LoadMoreView

/**
 * 包名:    com.noway.gg.toutiao
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/26
 * 版本:    V-1.0.0
 */
class CustomLoadMoreView : LoadMoreView() {
    override fun getLayoutId(): Int {

        return R.layout.load_more

    }

    override fun getLoadingViewId(): Int {

        return R.id.load_more_loading_view

    }

    override fun getLoadEndViewId(): Int {
        return R.id.load_more_load_end_view

    }

    override fun getLoadFailViewId(): Int {
        return R.id.load_more_load_fail_view

    }


}