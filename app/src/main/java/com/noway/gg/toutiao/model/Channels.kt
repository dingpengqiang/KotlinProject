package com.noway.gg.toutiao.model

/**
 * 包名:    com.noway.gg.toutiao.model
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/21
 * 版本:    V-1.0.0
 */
data class Channels(var msg: String?, var result: News?,var status: String?)



data class News(var num: String?, var list: List<NewsList>?,var channel: String?)

data class NewsList(var src: String?,var weburl: String?,var time: String?,var pic: String?,var title: String?,
                 var category: String?,var content: String?,var url: String?)