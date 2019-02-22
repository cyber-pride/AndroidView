package com.bluapp.androidview.WebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.bluapp.androidview.R;

public class WebViewActivity17 extends AppCompatActivity {
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view17);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        WebView webView = new WebView(WebViewActivity17.this);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.inducesmile.com/");
        relativeLayout.addView(webView);
    }
}
