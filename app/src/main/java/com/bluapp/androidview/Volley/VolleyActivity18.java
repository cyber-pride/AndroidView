package com.bluapp.androidview.Volley;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.bluapp.androidview.R;

public class VolleyActivity18 extends AppCompatActivity implements Response.ErrorListener, Response.Listener<Bitmap>{
    private ImageView imageView;
    private RequestQueue requestQueue;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley18);
        imageView = (ImageView) findViewById(R.id.imageView);
        requestQueue = Volley.newRequestQueue(this);
    }

    public void downloadBtn(View view){
        progressDialog = new ProgressDialog(VolleyActivity18.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
        ImageRequest imageRequest = new ImageRequest("https://www.inducesmile.com/wp-content/uploads/2019/01/inducesmilelog.png",
                this, 600, 600, ImageView.ScaleType.CENTER, null, this);
        requestQueue.add(imageRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressDialog.dismiss();
    }

    @Override
    public void onResponse(Bitmap bitmap) {
        progressDialog.dismiss();
        imageView.setImageBitmap(bitmap);

    }
}
