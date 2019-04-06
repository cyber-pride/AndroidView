package com.bluapp.androidview.VideoView;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bluapp.androidview.R;

public class VideoViewActivity9 extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view9);
        videoView = (VideoView)findViewById(R.id.videoView);
        //http://m.youtube.com/watch?v=Xprog0HC3aQ&app=m
        videoView.setVideoURI(Uri.parse("rtsp://r5---sn-5hne6n7e.googlevideo.com/Cj0LENy73wIaNAmk3cJBg-iaXhMYDSANFC3zIKlcMOCoAUIASARg1-TDn8fs551cigELTndaSktwMkZqakkM/536C324006419F0313CA2AF625794D8123511074.8916013EBD71B85735FE99BBEC10A978B05AA5E9/yt6/1/video.3gp"));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
    }
}
