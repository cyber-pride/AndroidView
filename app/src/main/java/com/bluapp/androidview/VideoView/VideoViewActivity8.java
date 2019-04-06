package com.bluapp.androidview.VideoView;

import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.bluapp.androidview.R;

public class VideoViewActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view8);

    }

    public void showAlert(View view){
        final VideoView taskvideoview = new VideoView(this);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);
        taskvideoview.setVideoURI(uri);
        taskvideoview.start();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Your Title");
        alertDialogBuilder.setMessage("What do you want?");
        alertDialogBuilder.setView(taskvideoview);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
