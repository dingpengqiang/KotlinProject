package com.noway.gg.toutiao.presenter

import android.content.Context
import com.noway.gg.toutiao.APPKEY
import com.noway.gg.toutiao.api.HomeApi
import com.noway.gg.toutiao.base.BaseFragmentPresenter
import com.noway.gg.toutiao.model.Channels
import com.noway.gg.toutiao.model.News
import com.noway.gg.toutiao.model.NewsList
import com.noway.gg.toutiao.presenter.interfaces.ITab1Presenter
import com.noway.gg.toutiao.ui.interfaces.ITab1Fragment
import com.noway.netutils.net.RxService
import com.noway.netutils.net.subscribers.NetCheckerSubscriber
import com.noway.netutils.net.utils.RxIoMain

/**
 * 包名:    com.noway.gg.toutiao.presenter
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/21
 * 版本:    V-1.0.0
 */
class Tab1Presenter : BaseFragmentPresenter<ITab1Fragment>(),ITab1Presenter{
    override fun getNews(content: Context, channel: String, num: String,start:String) {
       RxService.createApi(HomeApi::class.java).getNews(APPKEY,channel,num,start)
               .compose(RxIoMain._io_main(content))
               .subscribe(object : NetCheckerSubscriber<Channels>(content){
                   override fun onSuccess(t: Channels?) {
                       getView()?.getDataSuccess(t!!)
                   }

                   override fun onFailed(message: String?) {
                       getView()?.showMessage(message!!)
                   }

                   override fun onFinish() {
                      getView()?.finishRefresh()
                   }

               })
    }
}