package com.bluapp.androidview.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.bluapp.androidview.R;

public class AnimateBtnActivity extends AppCompatActivity {
    private Button animate1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_btn);
        animate1 = (Button)findViewById(R.id.animate1);

        animate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animate1.setText("Loading.....");
                Animation anim = AnimationUtils.loadAnimation(AnimateBtnActivity.this, R.anim.blink);
                animate1.startAnimation(anim);
            }
        });
    }
}
