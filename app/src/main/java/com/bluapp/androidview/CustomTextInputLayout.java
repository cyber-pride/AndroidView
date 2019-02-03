package com.bluapp.androidview;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class CustomTextInputLayout extends TextInputLayout {

    public CustomTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setErrorEnabled(boolean enabled){
        super.setErrorEnabled(enabled);
        if (!enabled){
            return;
        }
        try{
            Field field = TextInputLayout.class.getDeclaredField("mErrorView");
            field.setAccessible(true);
            TextView errorView = (TextView) field.get(this);
            if(errorView != null){
                errorView.setGravity(Gravity.RIGHT);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.END;
                errorView.setLayoutParams(params);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}