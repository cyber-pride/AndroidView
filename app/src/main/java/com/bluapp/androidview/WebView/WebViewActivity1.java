package com.bluapp.androidview.WebView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bluapp.androidview.R;

public class WebViewActivity1 extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view1);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/webview1.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.webview_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_webviewactivity2:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity2.class));
                return true;
            case R.id.action_webviewactivity3:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity3.class));
                return true;
            case R.id.action_webviewactivity4:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity4.class));
                return true;
            case R.id.action_webviewactivity5:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity5.class));
                return true;
            case R.id.action_webviewactivity6:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity6.class));
                return true;
            case R.id.action_webviewactivity7:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity7.class));
                return true;
            case R.id.action_webviewactivity8:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity8.class));
                return true;
            case R.id.action_webviewactivity9:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity9.class));
                return true;
            case R.id.action_webviewactivity10:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity10.class));
                return true;
            case R.id.action_webviewactivity11:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity11.class));
                return true;
            case R.id.action_webviewactivity12:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity12.class));
                return true;
            case R.id.action_webviewactivity13:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity13.class));
                return true;
            case R.id.action_webviewactivity14:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity14.class));
                return true;
            case R.id.action_webviewactivity15:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity15.class));
                return true;
            case R.id.action_webviewactivity16:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity16.class));
                return true;
            case R.id.action_webviewactivity17:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity17.class));
                return true;
            case R.id.action_webviewactivity18:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity18.class));
                return true;
            case R.id.action_webviewactivity19:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity19.class));
                return true;
            case R.id.action_webviewactivity20:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity20.class));
                return true;
            case R.id.action_webviewactivity21:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity21.class));
                return true;
            case R.id.action_webviewactivity22:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity22.class));
                return true;
            case R.id.action_webviewactivity23:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity23.class));
                return true;
            case R.id.action_webviewactivity24:
                startActivity(new Intent(WebViewActivity1.this, WebViewActivity24.class));
                return true;
        }

        return true;
    }
}
