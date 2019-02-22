package com.bluapp.androidview.WebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bluapp.androidview.R;

public class WebViewActivity3 extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view3);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/webview1.html");


        webView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String weburl){
                webView.loadUrl("javascript:testEcho('Javascript function in webview')");
            }
        });
    }
}
