package com.example.eureka.contactosdiarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.eureka.contactosdiarios.Database.Acceso;
import com.example.eureka.contactosdiarios.Pojo.Contacto;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    TextView nombre;
    TextView telefono;
    AutoCompleteTextView nombre1;
    AutoCompleteTextView telefono1;
    Button añadir;
    Intent intent;
    List<String> nombres = new ArrayList<>();
    String nom,tel;
    Acceso acceso;
    List<String> tele = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        Toolbar toolbar5 = (Toolbar) findViewById(R.id.toolbar5);
        toolbar5.setTitle("Modificar contacto");
        setSupportActionBar(toolbar5);

        acceso = new Acceso(this);

        nombre= (TextView) findViewById(R.id.textViewnombre2);
        telefono= (TextView) findViewById(R.id.textView3);
        nombre1= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        telefono1= (AutoCompleteTextView) findViewById(R.id.editex2);
        añadir= (Button) findViewById(R.id.añafra2);


        Bundle bundle = getIntent().getExtras();
        nom = bundle.getString("Nom");
        tel= bundle.getString("Tel");

        nombre1.setText(nom);
        telefono1.setText(tel);


        intent = new Intent(Main5Activity.this,MainActivity.class);

        Cargardatos();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nombres);
        nombre1.setThreshold(1);
        nombre1.setAdapter(adapter);

        ArrayAdapter<String> adaptertele = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,tele);
        telefono1.setThreshold(1);
        telefono1.setAdapter(adaptertele);


        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nombre",nombre1.getText().toString());
                intent.putExtra("tele",telefono1.getText().toString());
                setResult(52,intent);
                finish();

            }
        });

    }


    public void Cargardatos() {

        List<Contacto> contactoList = new ArrayList<>();
        acceso.CargarDatosentre(contactoList);

        for (int i =0; i< contactoList.size();i++){
            nombres.add(contactoList.get(i).getNombre());
            tele.add(contactoList.get(i).getTelefono());


        }

    }
}
