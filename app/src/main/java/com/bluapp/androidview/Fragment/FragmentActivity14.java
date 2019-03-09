package com.bluapp.androidview.Fragment;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bluapp.androidview.R;

public class FragmentActivity14 extends AppCompatActivity {
    private Button btn;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment14);
        fm = getSupportFragmentManager();

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment14 fragment14 = new Fragment14();
                // Show DialogFragment
                fragment14.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
                fragment14.show(fm, "Dialog Fragment");
            }
        });
    }
}
