package com.bluapp.androidview.Volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bluapp.androidview.R;

public class VolleyActivity19 extends AppCompatActivity {
    private RequestQueue requestQueue;
    private NetworkImageView mNetworkImageView;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley19);
        mNetworkImageView = (NetworkImageView) findViewById(R.id.networkImageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Instantiate the RequestQueue.
        mImageLoader = CustomVolleyRequestQueue.getInstance(getApplicationContext()).getImageLoader();
        //Image URL - This can point to any image file supported by Android
        final String url = "https://www.inducesmile.com/wp-content/uploads/2019/01/inducesmilelog.png";
        mImageLoader.get(url, ImageLoader.getImageListener(mNetworkImageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));
        mNetworkImageView.setImageUrl(url, mImageLoader);
    }
}
