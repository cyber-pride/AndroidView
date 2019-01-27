package com.bluapp.androidview.Button;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bluapp.androidview.R;

public class AlertDialogButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_button);
    }

    public void showAlert(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Your Title");
        alertDialogBuilder.setMessage("Show message over here");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
