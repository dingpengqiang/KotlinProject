package com.noway.gg.toutiao.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * 包名:    com.noway.gg.toutiao.model
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/22
 * 版本:    V-1.0.0
 */

data class Search(var msg: String?, var result: SearchNews?,var status: String?):Serializable


data class SearchNews(var num: String?, var list: List<SearchList>?,var keyword: String?):Serializable


data class SearchList(var src: String?,var weburl: String?,var time: String?,var pic: String?,var title: String?,
                    var category: String?,var content: String?,var url: String?):Serializable