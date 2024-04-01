package com.example.servicestudy2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.servicestudy2.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Calendar dateAndTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setInitialDateTime();
    }
    // showing the dialog window for selecting the date

    public void setDate(View v){
        new DatePickerDialog(MainActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }
    //setting the base date and time

    public void setTime(View v){
        new TimePickerDialog(MainActivity.this,t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE),true)
                .show();
    }

    private void setInitialDateTime() {
        binding.currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
        | DateUtils.FORMAT_SHOW_TIME));
    } //setting the selecting time handler

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    }; //setting the picking date handler

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.YEAR, dayOfMonth);
            setInitialDateTime();
        }
    };
}