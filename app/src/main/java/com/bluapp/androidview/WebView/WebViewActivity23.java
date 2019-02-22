package com.bluapp.androidview.WebView;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bluapp.androidview.R;

import java.util.HashMap;
import java.util.List;

public class WebViewActivity23 extends AppCompatActivity {
    private WebView webView;
    private SharedPreferences mPreferences;
    private String token="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view23);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSaveFormData(false);
        mPreferences = getSharedPreferences("User", MODE_PRIVATE);
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String token2= mPreferences.getString("auth_token","");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("x-auth-token", token);

        webView.getSettings().setAppCacheEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view,String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://www.inducesmile.com/");
    }
}
