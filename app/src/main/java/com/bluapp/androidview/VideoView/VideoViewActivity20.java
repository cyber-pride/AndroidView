package com.bluapp.androidview.VideoView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.bluapp.androidview.R;

public class VideoViewActivity20 extends AppCompatActivity {
    static final int MIN_WIDTH = 100;
    private FrameLayout.LayoutParams mRootParam;
    private VodView videoView;
    private ScaleGestureDetector mScaleGestureDetector;
    private GestureDetector mGestureDetector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view20);
        mRootParam = (LayoutParams) ((View) findViewById(R.id.root_view)).getLayoutParams();
        videoView = (VodView) findViewById(R.id.videoView);
        // Video Uri
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.test);
        videoView.setVideoURI(uri);
        // set up gesture listeners
        mScaleGestureDetector = new ScaleGestureDetector(this, new MyScaleGestureListener());
        mGestureDetector = new GestureDetector(this, new MySimpleOnGestureListener());
        videoView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mGestureDetector.onTouchEvent(event);
                mScaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        videoView.start();
        super.onResume();
    }

    @Override
    protected void onPause() {
        videoView.pause();
        super.onPause();
    }

    private class MySimpleOnGestureListener extends SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (videoView == null)
                return false;
            if (videoView.isPlaying())
                videoView.pause();
            else
                videoView.start();
            return true;
        }

    }

    private class MyScaleGestureListener implements OnScaleGestureListener {
        private int mW, mH;
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mW *= detector.getScaleFactor();
            mH *= detector.getScaleFactor();
            if (mW < MIN_WIDTH) { // limits width
                mW = videoView.getWidth();
                mH = videoView.getHeight();
            }
            Log.d("onScale", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
            videoView.setFixedVideoSize(mW, mH); // important
            mRootParam.width = mW;
            mRootParam.height = mH;
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            mW = videoView.getWidth();
            mH = videoView.getHeight();
            Log.d("onScaleBegin", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            Log.d("onScaleEnd", "scale=" + detector.getScaleFactor() + ", w=" + mW + ", h=" + mH);
        }

    }
}