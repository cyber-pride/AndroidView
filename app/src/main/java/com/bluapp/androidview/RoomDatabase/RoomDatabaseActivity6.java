package com.bluapp.androidview.RoomDatabase;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluapp.androidview.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class RoomDatabaseActivity6 extends AppCompatActivity {
    private Button backupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database6);
        backupBtn = (Button) findViewById(R.id.backupBtn);
        backupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backup();
            }
        });
    }

    private void backup(){
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if(sd.canWrite()){
                String currentDbPath = "//data//com.bluapp.androidview//databases//UserDb";
                String backupPath = "backup.db";
                File currentDb = new File(data, currentDbPath);
                File backupDb = new File(sd, backupPath);
                FileChannel src = new FileInputStream(currentDb).getChannel();
                FileChannel dst = new FileOutputStream(backupDb).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(RoomDatabaseActivity6.this,"Backup successfully",Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }
    }
}
