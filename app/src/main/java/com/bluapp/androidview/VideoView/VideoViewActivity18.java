package com.bluapp.androidview.VideoView;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.bluapp.androidview.R;

public class VideoViewActivity18 extends AppCompatActivity {
    private VideoView videoView;
    String[] videoArray = {"test", "video"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view18);
        Uri videoUri = Uri.parse("android.resource://" + VideoViewActivity18.this.getPackageName() + "/raw/" + videoArray[0]);

        videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVideoURI(videoUri);
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Uri videoUri = Uri.parse("android.resource://" + VideoViewActivity18.this.getPackageName() + "/raw/" + videoArray[1]);
                videoView.setVideoURI(videoUri);
                videoView.start();
            }
        });
    }
}
