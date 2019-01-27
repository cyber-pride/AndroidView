package com.bluapp.androidview.Button;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.bluapp.androidview.R;

public class SoundButtonActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private int btn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_button);

        mp = MediaPlayer.create(this, R.raw.music);
    }

    public void playSound(View view){
        btn++;
        if(btn == 1) {
            mp.setLooping(true);
            mp.start();
        } else {
            btn = 0;
            mp.pause();
        }
    }
}
