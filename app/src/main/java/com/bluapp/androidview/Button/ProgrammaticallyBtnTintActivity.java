package com.bluapp.androidview.Button;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.bluapp.androidview.R;

public class ProgrammaticallyBtnTintActivity extends AppCompatActivity {
    private Button btnTint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatically_btn_tint);
        btnTint = (Button) findViewById(R.id.btnTint);
        Drawable drawable = new ColorDrawable(Color.parseColor("#ffffff"));
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, Color.parseColor("#939393"));
        btnTint.setBackground(drawable);
    }
}
