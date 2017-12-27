package com.noway.gg.toutiao.api

import com.noway.gg.toutiao.model.*
import com.noway.netutils.net.base.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 包名:    com.noway.gg.toutiao.api
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/21
 * 版本:    V-1.0.0
 */
interface HomeApi {


    @GET("jisuapi/channel")
    fun getChannel(@Query("appkey")appkey:String): Observable<BaseResponse<ChannelList>>



    @GET("jisuapi/get")
    fun getNews(@Query("appkey")appkey:String,
                @Query("channel")channel:String,
                @Query("num")num:String,
                @Query("start")start:String): Observable<BaseResponse<Channels>>


    @GET("jisuapi/newSearch")
    fun getSearch(@Query("appkey")appkey:String,
                   @Query("keyword")keyword:String): Observable<BaseResponse<Search>>

}