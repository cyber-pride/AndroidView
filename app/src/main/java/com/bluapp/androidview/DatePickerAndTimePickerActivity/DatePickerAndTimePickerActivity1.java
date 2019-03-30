package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;

import com.bluapp.androidview.R;

public class DatePickerAndTimePickerActivity1 extends AppCompatActivity {
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker1);
        //setting default date
        year = 2000;
        month = 5;
        day = 6;

    }

    public void ShowDatePicker(View view){
        DatePickerDialog dpd = new DatePickerDialog(DatePickerAndTimePickerActivity1.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, year, month, day);
        dpd.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.datepickerandtimepicker_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_datepickerandtimepickeractivity2:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity2.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity3:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity3.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity4:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity4.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity5:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity5.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity6:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity6.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity7:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity7.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity8:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity8.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity9:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity9.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity10:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity10.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity11:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity11.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity12:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity12.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity13:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity13.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity14:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity14.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity15:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity15.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity16:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity16.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity17:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity17.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity18:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity18.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity19:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity19.class));
                return true;

            case R.id.action_datepickerandtimepickeractivity20:
                startActivity(new Intent(DatePickerAndTimePickerActivity1.this, DatePickerAndTimePickerActivity20.class));
                return true;
        }

        return true;
    }
}
