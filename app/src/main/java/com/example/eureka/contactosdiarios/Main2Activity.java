package com.example.eureka.contactosdiarios;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView nombre;
    TextView telefono;
    AutoCompleteTextView nombre1;
    AutoCompleteTextView telefono1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        nombre= (TextView) findViewById(R.id.textViewnombre);



    }

}
