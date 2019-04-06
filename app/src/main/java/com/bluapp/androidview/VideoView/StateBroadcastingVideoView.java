package com.bluapp.androidview.VideoView;



import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class StateBroadcastingVideoView extends VideoView{
    public interface PlayPauseListener {
        void onPlay();
        void onPause();
    }

    private PlayPauseListener mListener;

    public StateBroadcastingVideoView(Context context) {
        super(context);
    }

    public StateBroadcastingVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StateBroadcastingVideoView(Context context, AttributeSet attrs, int theme) {
        super(context, attrs, theme);
    }

    @Override
    public void pause() {
        super.pause();
        if(mListener != null) {
            mListener.onPause();
        }
    }

    @Override
    public void start() {
        super.start();
        if(mListener != null) {
            mListener.onPlay();
        }
    }

    public void setPlayPauseListener(PlayPauseListener listener) {
        mListener = listener;
    }

}