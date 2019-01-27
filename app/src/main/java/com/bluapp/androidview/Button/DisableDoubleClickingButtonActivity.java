package com.bluapp.androidview.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class DisableDoubleClickingButtonActivity extends AppCompatActivity {
    private Button disableBtn;
    private int btn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disable_double_clicking_button);
        disableBtn = (Button) findViewById(R.id.disableBtn);

        disableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn++;
                if(btn == 1) {
                    Toast.makeText(DisableDoubleClickingButtonActivity.this,"Run Event", Toast.LENGTH_SHORT).show();
                } else {
                   disableBtn.setEnabled(false);
                }
            }
        });
    }
}
