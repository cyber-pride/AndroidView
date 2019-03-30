package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bluapp.androidview.R;

import java.util.Calendar;

public class DatePickerAndTimePickerActivity19 extends AppCompatActivity {
    private int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker19);
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
    }

    public void ShowTimePicker(View view){
        TimePickerDialog tpd = new TimePickerDialog(DatePickerAndTimePickerActivity19.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                Calendar datetime = Calendar.getInstance();
                Calendar calendar = Calendar.getInstance();
                datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                datetime.set(Calendar.MINUTE, minute);
                if(datetime.getTimeInMillis()>=calendar.getTimeInMillis()){
                    int hour = hourOfDay % 12;
                }else{
                    Toast.makeText(DatePickerAndTimePickerActivity19.this,"Invalid Time", Toast.LENGTH_LONG).show();
                }

            }
        }, hour, minute, true);
        tpd.show();

    }

}
