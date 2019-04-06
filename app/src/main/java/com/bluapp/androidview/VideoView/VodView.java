package com.bluapp.androidview.VideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class VodView extends VideoView {

    public VodView(Context context) {
        super(context);
    }

    public VodView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VodView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void setFixedVideoSize(int width, int height)
    {
        getHolder().setFixedSize(width, height);
    }
}