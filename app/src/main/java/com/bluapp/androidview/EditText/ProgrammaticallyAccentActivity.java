package com.bluapp.androidview.EditText;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.bluapp.androidview.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ProgrammaticallyAccentActivity extends AppCompatActivity {
    private TextInputLayout textinputlayout;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatically_accent);
        textinputlayout = (TextInputLayout) findViewById(R.id.textinputlayout);
        editText = (EditText) findViewById(R.id.fullname);
        setThemecolor(getResources().getColor(R.color.colorPrimaryDark));



    }

    private void setThemecolor(int color){
        try{
            Field field = textinputlayout.getClass().getDeclaredField("focusedTextColor");
            field.setAccessible(true);
            int[][] states = new int[][]{new int[]{}};

            int [] colors = new int[]{color};
            ColorStateList colorStateList = new ColorStateList(states, colors);
            field.set(textinputlayout, colorStateList);

            Field field2 = textinputlayout.getClass().getDeclaredField("defaultHintTextColor");
            field2.setAccessible(true);
            field2.set(textinputlayout, colorStateList);

            Method method = textinputlayout.getClass().getDeclaredMethod("updateLabelState", boolean.class);
            method.setAccessible(true);
            method.invoke(textinputlayout, true);

            Drawable drawable = textinputlayout.getEditText().getBackground();
            DrawableCompat.setTint(drawable, color);
            textinputlayout.getEditText().setBackground(drawable);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
