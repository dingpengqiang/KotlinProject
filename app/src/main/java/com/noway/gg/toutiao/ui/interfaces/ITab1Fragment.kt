package com.noway.gg.toutiao.ui.interfaces

import com.noway.gg.toutiao.base.IBaseFragmentView
import com.noway.gg.toutiao.model.ChannelList
import com.noway.gg.toutiao.model.Channels
import com.noway.gg.toutiao.model.News
import com.noway.gg.toutiao.model.NewsList

/**
 * 包名:    com.noway.gg.toutiao.ui.interfaces
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/21
 * 版本:    V-1.0.0
 */
interface ITab1Fragment :IBaseFragmentView{

    fun requestData()
    fun getDataSuccess(channels: Channels)
}