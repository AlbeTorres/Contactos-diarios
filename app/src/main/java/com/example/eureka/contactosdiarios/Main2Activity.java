package com.example.eureka.contactosdiarios;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        nombre= (TextView) findViewById(R.id.textViewnombre);
        telefono= (TextView) findViewById(R.id.textView2);
        nombre1= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        telefono1= (EditText) findViewById(R.id.editex);
        añadir= (Button) findViewById(R.id.añafra);

        intent = new Intent(Main2Activity.this,MainActivity.class);


        Cargardatos();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nombres);
        nombre1.setThreshold(1);
        nombre1.setAdapter(adapter);


        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nombre",nombre1.getText().toString());
                intent.putExtra("tele",telefono1.getText().toString());
                setResult(RESULT_OK,intent);
                finish();

            }
        });



    }

    public void Cargardatos() {
        nombres.add("manolo");
        nombres.add("manuel");
        nombres.add("mercedes");
        nombres.add("alber");
        nombres.add("alriel");

    }

}
