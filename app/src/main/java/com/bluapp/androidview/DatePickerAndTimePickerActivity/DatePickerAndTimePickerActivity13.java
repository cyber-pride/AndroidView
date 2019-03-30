package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class DatePickerAndTimePickerActivity13 extends AppCompatActivity {
    private int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker13);
        //setting default time
        hour = 00;
        minute = 00;
    }

    public void ShowTimePicker(View view){
        TimePickerDialog tpd = new TimePickerDialog(DatePickerAndTimePickerActivity13.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String time = new StringBuilder().append(String.format("%02d", selectedHour)).append(":").append(String.format("%02d", selectedMinute)).toString();
                Toast.makeText(DatePickerAndTimePickerActivity13.this, time,Toast.LENGTH_LONG).show();
            }
        }, hour, minute, true);
        tpd.show();

    }
}
