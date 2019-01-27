package com.bluapp.androidview.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bluapp.androidview.R;

public class ProgrammaticallyMarginBtnActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatically_margin_btn);
        button = (Button)findViewById(R.id.marginBtn);

        RelativeLayout.LayoutParams relParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relParam.setMargins(10, 10, 10, 10);
        relParam.addRule(RelativeLayout.CENTER_IN_PARENT);
        button.setLayoutParams(relParam);


    }
}
