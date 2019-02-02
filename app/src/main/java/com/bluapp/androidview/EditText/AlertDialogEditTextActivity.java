package com.bluapp.androidview.EditText;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bluapp.androidview.R;

public class AlertDialogEditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_edit_text);
    }

    public void showAlert(View view){
        final EditText taskEditText = new EditText(this);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Your Title");
        alertDialogBuilder.setMessage("What do you want?");
        alertDialogBuilder.setView(taskEditText);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
