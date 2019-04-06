package com.bluapp.androidview.VideoView;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.bluapp.androidview.R;

public class VideoViewActivity16 extends AppCompatActivity {
    private StateBroadcastingVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view16);
        videoView = (StateBroadcastingVideoView)findViewById(R.id.videoView);
        videoView.setMediaController(new MediaController(this));
        videoView.setPlayPauseListener(new StateBroadcastingVideoView.PlayPauseListener() {
            @Override
            public void onPlay() {

            }

            @Override
            public void onPause() {
                Toast.makeText(VideoViewActivity16.this, "Video pause", Toast.LENGTH_SHORT).show();
            }
        });
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
