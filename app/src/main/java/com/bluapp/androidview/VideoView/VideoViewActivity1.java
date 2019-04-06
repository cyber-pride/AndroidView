package com.bluapp.androidview.VideoView;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.VideoView;

import com.bluapp.androidview.R;

public class VideoViewActivity1 extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view1);
        videoView = (VideoView)findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);
        videoView.setVideoURI(uri);
        videoView.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.videoview_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_videoviewactivity2:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity2.class));
                return true;

            case R.id.action_videoviewactivity3:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity3.class));
                return true;

            case R.id.action_videoviewactivity4:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity4.class));
                return true;

            case R.id.action_videoviewactivity5:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity5.class));
                return true;

            case R.id.action_videoviewactivity6:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity6.class));
                return true;

            case R.id.action_videoviewactivity7:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity7.class));
                return true;

            case R.id.action_videoviewactivity8:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity8.class));
                return true;

            case R.id.action_videoviewactivity9:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity9.class));
                return true;

            case R.id.action_videoviewactivity10:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity10.class));
                return true;

            case R.id.action_videoviewactivity11:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity11.class));
                return true;

            case R.id.action_videoviewactivity12:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity12.class));
                return true;

            case R.id.action_videoviewactivity13:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity13.class));
                return true;

            case R.id.action_videoviewactivity14:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity14.class));
                return true;

            case R.id.action_videoviewactivity15:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity15.class));
                return true;

            case R.id.action_videoviewactivity16:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity16.class));
                return true;

            case R.id.action_videoviewactivity17:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity17.class));
                return true;

            case R.id.action_videoviewactivity18:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity18.class));
                return true;

            case R.id.action_videoviewactivity19:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity19.class));
                return true;

            case R.id.action_videoviewactivity20:
                startActivity(new Intent(VideoViewActivity1.this, VideoViewActivity20.class));
                return true;
        }

        return true;
    }
}
