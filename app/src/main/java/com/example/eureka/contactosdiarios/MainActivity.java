package com.example.eureka.contactosdiarios;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eureka.contactosdiarios.Fragment.Imagen;
import com.example.eureka.contactosdiarios.Pojo.Contacto;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity   {

    Fragment fragment;
    Toolbar toolbar;
    RecyclerView recyclerView;
    List<Contacto> contactoList = new ArrayList<>();
    ContactoAdapter adapter;
    Button añadir;
    Button contacto;
    Toast toast;
    Intent intent;
    Intent intent2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        añadir = (Button) findViewById(R.id.aña);

        contacto = (Button) findViewById(R.id.cont);

        intent = new Intent(this,Main2Activity.class);
        intent2 = new Intent(this,Main3Activity.class);


        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });

        Cargardatos();
        if (contactoList.isEmpty()){
            fragment = new Imagen();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame,fragment)
                    .commit();
             } else{
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter = new ContactoAdapter(this,contactoList);
            recyclerView.setAdapter(adapter);
        }


    }


    public void Cargardatos(){

        contactoList.add(new Contacto("Manolo","55667788"));
        contactoList.add(new Contacto("Manolo","55667788"));
        contactoList.add(new Contacto("Manolo","55667788"));
        contactoList.add(new Contacto("Manolo","55667788"));
        contactoList.add(new Contacto("Manolo","55667788"));
        contactoList.add(new Contacto("Manolo","55667788"));
        contactoList.add(new Contacto("Manolo","55667788"));
        contactoList.add(new Contacto("Manolo","55667788"));
    }





}
