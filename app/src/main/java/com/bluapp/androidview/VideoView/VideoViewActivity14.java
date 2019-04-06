package com.bluapp.androidview.VideoView;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.bluapp.androidview.R;

public class VideoViewActivity14 extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view14);
        videoView = (VideoView)findViewById(R.id.videoView);
        ///storage/emulated/0test.mp4
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory()+"/test.mp4");
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
