package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bluapp.androidview.R;

import java.util.Calendar;
import java.util.Date;

public class DatePickerAndTimePickerActivity18 extends AppCompatActivity {
    private int year, monthofyear, dayofmonth, hourofday, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker18);
    }

    public void CreateDateObject(View view){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthofyear);
        calendar.set(Calendar.DATE, dayofmonth);
        calendar.set(Calendar.HOUR_OF_DAY, hourofday);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        Toast.makeText(DatePickerAndTimePickerActivity18.this,"date Object: 0"+date, Toast.LENGTH_LONG).show();
    }
}
