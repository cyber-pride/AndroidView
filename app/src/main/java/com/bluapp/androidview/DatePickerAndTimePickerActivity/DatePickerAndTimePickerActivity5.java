package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.bluapp.androidview.R;

import java.util.Date;

public class DatePickerAndTimePickerActivity5 extends AppCompatActivity {
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker5);
        //setting default date
        year = 2019;
        month = 4;
        day = 28;

    }

    public void ShowDatePicker(View view){
        DatePickerDialog dpd = new DatePickerDialog(DatePickerAndTimePickerActivity5.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, year, month, day);
        //disaple future date
        dpd.getDatePicker().setMaxDate(new Date().getTime());
        dpd.show();
    }
}
