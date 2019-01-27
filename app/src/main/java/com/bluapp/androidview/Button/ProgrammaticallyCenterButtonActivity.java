package com.bluapp.androidview.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bluapp.androidview.R;

public class ProgrammaticallyCenterButtonActivity extends AppCompatActivity {

    private Button centerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatically_center_button);

        centerBtn = (Button)findViewById(R.id.btn);

        RelativeLayout.LayoutParams centerRel = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        centerRel.setMargins(10, 10, 10, 10);
        centerRel.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.centerBtn.setLayoutParams(centerRel);
    }
}
