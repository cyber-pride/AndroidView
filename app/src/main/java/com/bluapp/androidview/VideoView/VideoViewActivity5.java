package com.bluapp.androidview.VideoView;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.bluapp.androidview.R;

public class VideoViewActivity5 extends AppCompatActivity {
    private VideoView videoView;
    private Button buttonCapture;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private MediaController myMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view5);
        videoView = (VideoView) findViewById(R.id.videoView);
        buttonCapture = (Button) findViewById(R.id.capture);
        mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(VideoViewActivity5.this, Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test));
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test));
        myMediaController = new MediaController(this);
        videoView.setMediaController(myMediaController);

        videoView.setOnCompletionListener(videoViewCompletionListener);
        videoView.setOnPreparedListener(videoViewPreparedListener);
        videoView.setOnErrorListener(videoViewErrorListener);

        videoView.requestFocus();
        videoView.start();
        buttonCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int currentPosition = videoView.getCurrentPosition(); //in millisecond
                Toast.makeText(VideoViewActivity5.this, "Current Position: " + currentPosition + " (ms)", Toast.LENGTH_LONG).show();
                Bitmap bmFrame = mediaMetadataRetriever.getFrameAtTime(currentPosition * 1000); //unit in microsecond
                if (bmFrame == null) {
                    Toast.makeText(VideoViewActivity5.this, "null!", Toast.LENGTH_LONG).show();
                } else {
                    AlertDialog.Builder myCaptureDialog = new AlertDialog.Builder(VideoViewActivity5.this);
                    ImageView capturedImageView = new ImageView(VideoViewActivity5.this);
                    capturedImageView.setImageBitmap(bmFrame);
                    ActionBar.LayoutParams capturedImageViewLayoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    capturedImageView.setLayoutParams(capturedImageViewLayoutParams);
                    myCaptureDialog.setView(capturedImageView);
                    myCaptureDialog.show();
                }

            }
        });
    }

    MediaPlayer.OnCompletionListener videoViewCompletionListener = new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer arg0) {
                    Toast.makeText(VideoViewActivity5.this, "End of Video", Toast.LENGTH_LONG).show();
                }
            };

    MediaPlayer.OnPreparedListener videoViewPreparedListener = new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    long duration = videoView.getDuration(); //in millisecond
                    Toast.makeText(VideoViewActivity5.this, "Duration: " + duration + " (ms)", Toast.LENGTH_LONG).show();

                }
            };

    MediaPlayer.OnErrorListener videoViewErrorListener = new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Toast.makeText(VideoViewActivity5.this, "Error!!!", Toast.LENGTH_LONG).show();
                    return true;
                }
            };

}