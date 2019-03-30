package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.bluapp.androidview.R;

import java.util.Calendar;

public class DatePickerAndTimePickerActivity10 extends AppCompatActivity {
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker10);
        //setting default date
        year = 2028;
        month = 4;
        day = 28;

    }

    public void ShowDatePicker(View view){
        DatePickerDialog dpd = new DatePickerDialog(DatePickerAndTimePickerActivity10.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, year, month, day);
        Calendar calendarmin = Calendar.getInstance();
        calendarmin.set(2019, 3, 31 );
        Calendar calendarmax = Calendar.getInstance();
        calendarmax.set(2019, 4, 31 );
        dpd.getDatePicker().setMinDate(calendarmin.getTimeInMillis());
        dpd.getDatePicker().setMaxDate(calendarmax.getTimeInMillis());
        dpd.show();
    }
}
