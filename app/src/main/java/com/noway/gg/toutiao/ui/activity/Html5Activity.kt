package com.noway.gg.toutiao.ui.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.*
import com.noway.gg.toutiao.R
import com.noway.gg.toutiao.base.BaseActivity
import com.noway.netutils.utils.WebViewUtils
import kotlinx.android.synthetic.main.activity_html5.*

class Html5Activity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_html5)

        super.onCreate(savedInstanceState)
    }

    override fun initTitle() {

    }

    override fun initView() {
        var url = intent.getStringExtra("url")
        WebViewUtils.initWebView(this,web_view)
        web_view.webChromeClient = MyWebChromeClient()
        web_view.webViewClient = MyWebViewClient()
        web_view.loadUrl(url)



    }

    override fun initPresenter() {

    }

    override fun initData() {

    }

    override fun setStatusBar() {

    }

    private open class MyWebChromeClient : WebChromeClient()
    private open class MyWebViewClient : WebViewClient(){
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)

        }

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
            super.onReceivedError(view, request, error)


        }


    }
}
