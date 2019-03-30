package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.TimePickerDialog;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import com.bluapp.androidview.R;

import java.util.Locale;

public class DatePickerAndTimePickerActivity16 extends AppCompatActivity {
    private int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker16);
        //setting default time
        hour = 00;
        minute = 00;
        Locale locale = Locale.US;
        Locale.setDefault(locale);

        Configuration configuration = getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        createConfigurationContext(configuration);
    }

    public void ShowTimePicker(View view){
        TimePickerDialog tpd = new TimePickerDialog(DatePickerAndTimePickerActivity16.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
            }
        }, hour, minute, true);
        tpd.show();
    }
}
