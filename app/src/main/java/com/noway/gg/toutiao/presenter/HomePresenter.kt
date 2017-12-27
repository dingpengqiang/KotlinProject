package com.noway.gg.toutiao.presenter

import android.content.Context
import com.noway.gg.toutiao.APPKEY
import com.noway.gg.toutiao.api.HomeApi
import com.noway.gg.toutiao.base.BaseFragmentPresenter
import com.noway.gg.toutiao.model.ChannelList
import com.noway.gg.toutiao.presenter.interfaces.IHomePresenter
import com.noway.gg.toutiao.ui.interfaces.IHomeFragment
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
class HomePresenter : BaseFragmentPresenter<IHomeFragment>(),IHomePresenter{
    override fun getChannel(content: Context) {

        RxService.createApi(HomeApi::class.java).getChannel(APPKEY)
                .compose(RxIoMain._io_main(content))
                .subscribe(object: NetCheckerSubscriber<ChannelList>(content){
                    override fun onSuccess(t: ChannelList?) {
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