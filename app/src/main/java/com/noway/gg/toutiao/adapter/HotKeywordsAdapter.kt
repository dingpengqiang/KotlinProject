package com.noway.gg.toutiao.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.google.android.flexbox.FlexboxLayoutManager
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.model.SearchList

/**
 * 包名:    com.noway.gg.toutiao.adapter
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/25
 * 版本:    V-1.0.0
 */
class HotKeywordsAdapter(layoutResId: Int, data: MutableList<SearchList>?) : BaseQuickAdapter<SearchList, BaseViewHolder>(layoutResId, data) {



    /**
     * Kotlin的函数可以作为参数，写callback的时候，可以不用interface了
     */

    private var mOnTagItemClick: ((tag:String) -> Unit)? = null

    fun setOnTagItemClickListener(onTagItemClickListener:(tag:String) -> Unit) {
        this.mOnTagItemClick = onTagItemClickListener
    }


    override fun convert(holder: BaseViewHolder?, item: SearchList?) {


        holder?.setText(R.id.tv_title,item?.title?.substring(0,2))

        val params = holder?.getView<TextView>(R.id.tv_title)?.layoutParams
        if(params is FlexboxLayoutManager.LayoutParams){
            params.flexGrow = 1.0f
        }

        holder?.getView<TextView>(R.id.tv_title)?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mOnTagItemClick?.invoke(item.toString())
            }

        })

    }
}