package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bluapp.androidview.R;

import java.util.Calendar;

public class DatePickerAndTimePickerActivity20 extends AppCompatActivity {
    private int hour, minute;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker20);
        txt = (TextView) findViewById(R.id.txt);
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
    }

    public void ShowTimePicker(View view){
        TimePickerDialog tpd = new TimePickerDialog(DatePickerAndTimePickerActivity20.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                String etime = new StringBuilder().append(String.format("%02d", hourOfDay)).append(":").append(String.format("%02d", minute)).toString();
                txt.setText(etime);

            }
        }, hour, minute, true);
        tpd.show();

    }

}
