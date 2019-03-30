package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.bluapp.androidview.R;

import java.util.Date;

public class DatePickerAndTimePickerActivity2 extends AppCompatActivity {
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker2);
        //setting default date
        year = 2000;
        month = 5;
        day = 6;
    }

    public void ShowDatePicker(View view){
        DatePickerDialog dpd = new DatePickerDialog(DatePickerAndTimePickerActivity2.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, year, month, day);
        //disaple past date
        dpd.getDatePicker().setMinDate(new Date().getTime());
        dpd.show();
    }
}
