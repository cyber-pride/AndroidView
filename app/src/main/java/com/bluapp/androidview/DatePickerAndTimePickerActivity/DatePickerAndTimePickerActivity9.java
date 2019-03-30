package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.bluapp.androidview.R;

import java.util.Calendar;

public class DatePickerAndTimePickerActivity9 extends AppCompatActivity {
    private Button StartDate;
    private Button EndDate;
    int year_y, year_x, month_y, month_x, day_y, day_x;
    private static final int DIALOG_ID_1 = 0, DIALOG_ID_2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker9);

        final Calendar calendar = Calendar.getInstance();
        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_YEAR);

        year_y = year_x;
        month_y = month_x;
        day_y = day_x+1;

        StartDate = (Button) findViewById(R.id.button1);
        EndDate = (Button) findViewById(R.id.button2);

        StartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID_1);
            }
        });

        EndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID_2);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID_1){
            return new DatePickerDialog(this, dpd, year_x, month_x, day_x);
        }else if(id == DIALOG_ID_2)
           return new DatePickerDialog(this, dpd1, year_y, month_y, day_y);
        else return null;
    }

    private DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {
            year_x = year;
            month_x = monthofyear + 1;
            day_x = dayofmonth;
            Toast.makeText(DatePickerAndTimePickerActivity9.this,"StartDate: "+day_x+" / "+month_x+" / "+year_x, Toast.LENGTH_LONG).show();
        }
    };

    private DatePickerDialog.OnDateSetListener dpd1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {
            year_y = year;
            month_y = monthofyear + 1;
            day_y = dayofmonth;
            Toast.makeText(DatePickerAndTimePickerActivity9.this,"EndDate: "+day_y+" / "+month_y+" / "+year_y, Toast.LENGTH_LONG).show();
        }
    };


}
