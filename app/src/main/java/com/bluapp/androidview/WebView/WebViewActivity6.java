package com.bluapp.androidview.WebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class WebViewActivity6 extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view6);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.inducesmile.com/");
    }

    public void clearcache(View view){
        Toast.makeText(WebViewActivity6.this, "Cache cleared", Toast.LENGTH_LONG).show();
        webView.clearCache(true);
        webView.reload();
    }
}
