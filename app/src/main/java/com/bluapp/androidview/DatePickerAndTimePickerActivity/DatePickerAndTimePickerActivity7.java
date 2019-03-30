package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.bluapp.androidview.R;

import java.util.Calendar;

public class DatePickerAndTimePickerActivity7 extends AppCompatActivity {
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker7);
        //setting default date
        year = 2028;
        month = 4;
        day = 28;

    }

    public void ShowDatePicker(View view){
        DatePickerDialog dpd = new DatePickerDialog(DatePickerAndTimePickerActivity7.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, year, month, day);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31 );
        dpd.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        dpd.show();
    }
}
