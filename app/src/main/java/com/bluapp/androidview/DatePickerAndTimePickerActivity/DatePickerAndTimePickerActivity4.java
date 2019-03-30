package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.bluapp.androidview.R;

public class DatePickerAndTimePickerActivity4 extends AppCompatActivity {
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker4);
        //setting default date
        year = 2019;
        month = 3;
        day = 28;

    }

    public void ShowDatePicker(View view){
        DatePickerDialog dpd = new DatePickerDialog(DatePickerAndTimePickerActivity4.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, year, month, day);
        dpd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dpd.show();
    }
}
