package com.noway.gg.toutiao.ui.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.noway.gg.toutiao.AppContext
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.base.BaseFragment
import com.noway.gg.toutiao.showToast
import com.noway.gg.toutiao.ui.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * 包名:    com.noway.gg.toutiao.ui.fragment
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/12
 * 版本:    V-1.0.0
 */
class MineFragment : BaseFragment() {


    val TAG:String = MineFragment::class.java.simpleName

    var mainActivity : Activity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // 布局导入
        layout = inflater.inflate(R.layout.fragment_mine, container, false)
        return layout
    }


    override fun initTitle() {

    }

    override fun initView() {




        night_mode_switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                showToast("黑夜")
                night_mode_switch.postDelayed({
                    AppContext.me().setTheme(context as AppCompatActivity?,true)
                },1000)


            }else{
                showToast("白天")
                night_mode_switch.postDelayed({
                    AppContext.me().setTheme(context as AppCompatActivity?,false)
                },1000)
            }



//            final Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
            //重启app
            var  intent = context!!.packageManager.getLaunchIntentForPackage(context?.packageName)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        })
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
         mainActivity = context as MainActivity

    }
    override fun initPresenter() {

    }

    override fun initData() {

    }

    override fun setStatusBar() {

    }

}