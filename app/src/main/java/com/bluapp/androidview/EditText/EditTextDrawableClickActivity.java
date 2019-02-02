package com.bluapp.androidview.EditText;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class EditTextDrawableClickActivity extends AppCompatActivity {
    private EditText fullname;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_drawable_click);
        fullname = (EditText) findViewById(R.id.fullname);

        fullname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Drawble_Left = 0;
                //final int Drawble_top = 1;
               // final int Drawble_right = 2;
               // final int Drawble_bottom = 3;
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX()<= (fullname.getCompoundDrawables()[Drawble_Left].getBounds().width())){
                        Toast.makeText(EditTextDrawableClickActivity.this, "Click Action", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
