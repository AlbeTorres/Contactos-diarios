package com.example.eureka.contactosdiarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class Main6Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

       Toolbar toolbar6 = (android.support.v7.widget.Toolbar) findViewById(R.id.pan);
        toolbar6.setTitle("");
        setSupportActionBar(toolbar6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


}
