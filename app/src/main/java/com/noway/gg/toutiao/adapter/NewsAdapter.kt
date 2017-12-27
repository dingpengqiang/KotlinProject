package com.noway.gg.toutiao.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.model.News
import com.noway.gg.toutiao.model.NewsList
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * 包名:    com.noway.gg.toutiao.adapter
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/21
 * 版本:    V-1.0.0
 */
class NewsAdapter(layoutResId: Int, data: MutableList<NewsList>?) : BaseQuickAdapter<NewsList, BaseViewHolder>(layoutResId, data) {


    override fun convert(helper: BaseViewHolder?, item: NewsList?) {
        helper?.setText(R.id.item_title,item?.title)
                ?.setText(R.id.item_content,item?.content)
                ?.setText(R.id.item_src,item?.src)
                ?.setText(R.id.item_time,item?.time)


        var imageView = helper?.getView<ImageView>(R.id.imageView)
        var content = helper?.getView<TextView>(R.id.item_content)
        Glide.with(mContext).load(item?.pic).into(imageView as ImageView)
        if (item?.pic.isNullOrEmpty()){
            imageView.visibility = View.GONE
            content?.maxLines = 3
            content?.minLines = 0
        }else{
            imageView.visibility = View.VISIBLE
            content?.maxLines = 5
            content?.minLines = 5
        }

    }

}