package com.bluapp.androidview.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bluapp.androidview.R;

public class DynamicButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_button);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        RelativeLayout.LayoutParams relParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relParam.addRule(RelativeLayout.CENTER_IN_PARENT);
        relParam.setMargins(10, 10, 10,10);
        Button btn = new Button(this);
        btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btn.setText("Button");
        btn.setTextColor(getResources().getColor(R.color.white));
        relativeLayout.addView(btn, relParam);
    }

}
