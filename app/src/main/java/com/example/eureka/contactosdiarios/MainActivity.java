package com.example.eureka.contactosdiarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.eureka.contactosdiarios.Pojo.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    List<Contacto> contactoList = new ArrayList<>();
    ContactoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        Cargardatos();
        adapter = new ContactoAdapter(this,contactoList);
        recyclerView.setAdapter(adapter);
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
