package com.example.eureka.contactosdiarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    TextView nombre;
    TextView telefono;
    AutoCompleteTextView nombre1;
    EditText telefono1;
    Button añadir;
    Intent intent;
    List<String> nombres = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        Toolbar toolbar5 = (Toolbar) findViewById(R.id.toolbar5);
        toolbar5.setTitle("Modificar contacto");
        setSupportActionBar(toolbar5);


        nombre= (TextView) findViewById(R.id.textViewnombre2);
        telefono= (TextView) findViewById(R.id.textView3);
        nombre1= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        telefono1= (EditText) findViewById(R.id.editex2);
        añadir= (Button) findViewById(R.id.añafra2);

        intent = new Intent(Main5Activity.this,MainActivity.class);






    }
}
