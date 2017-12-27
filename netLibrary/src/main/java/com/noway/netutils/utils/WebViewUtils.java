package com.noway.netutils.utils;

import android.app.Activity;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * 包名:    com.noway.netutils.utils
 * 标题:
 * 描述:    TODO
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/22
 * 版本:    V-1.0.0
 */
public class WebViewUtils {

    public static void initWebView(final Activity activity, final WebView webView) {

        webView.setDrawingCacheEnabled(true);
        webView.setHorizontalFadingEdgeEnabled(false);
        webView.setVerticalFadingEdgeEnabled(false);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);//启用缓存
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);//设置缓存模式
        settings.setAllowFileAccess(true);
        settings.setDatabaseEnabled(true);

        //强制调节字体大小，单行显示，不会为系统字体大小设置改变页面布局
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        } else {
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }
        });


    }
}
