package com.bluapp.androidview.Button;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bluapp.androidview.R;

public class StartActivityButtonActivity extends AppCompatActivity {

    private Button startactivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_button);

        startactivityBtn =(Button) findViewById(R.id.startactivity);

        startactivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivityButtonActivity.this, ButtonActivity.class));
            }
        });
    }
}
