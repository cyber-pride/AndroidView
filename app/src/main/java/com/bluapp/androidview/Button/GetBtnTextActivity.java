package com.bluapp.androidview.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class GetBtnTextActivity extends AppCompatActivity {
    private Button getBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_btn_text);
        getBtn = (Button)findViewById(R.id.BtnText);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GetBtnTextActivity.this, "Result: "+getBtn.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
