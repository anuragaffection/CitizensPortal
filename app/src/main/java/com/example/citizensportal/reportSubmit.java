package com.example.citizensportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class reportSubmit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_submit);



        Spinner spinner = findViewById(R.id.spinner);

        ArrayList<String> arrIdName = new ArrayList<>();

        arrIdName.add("Drunk & Drive  ");
        arrIdName.add("Without Helmet");
        arrIdName.add("Using Phone While Driving");
        arrIdName.add("Over Speeding ");
        arrIdName.add("Violation of Traffic Rule");
        arrIdName.add("Missing Never Plate  ");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrIdName);
        spinner.setAdapter(spinnerAdapter);
    }
}