package com.bluapp.androidview.VideoView;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bluapp.androidview.R;

public class VideoViewActivity17 extends AppCompatActivity {
    private VideoView videoView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view17);
        videoView = (VideoView)findViewById(R.id.videoView);
        progressDialog = ProgressDialog.show(VideoViewActivity17.this, "", "Buffering video...", true);
        progressDialog.setCancelable(true);

        StreamVideo();
    }

    private void StreamVideo() {
        try {
            getWindow().setFormat(PixelFormat.TRANSLUCENT);
            MediaController mediaController = new MediaController(VideoViewActivity17.this);
            mediaController.setAnchorView(videoView);
            Uri uri = Uri.parse("rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov");
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    progressDialog.dismiss();
                    videoView.start();
                }
            });

        } catch(Exception e) {
            progressDialog.dismiss();
        }

    }
}
