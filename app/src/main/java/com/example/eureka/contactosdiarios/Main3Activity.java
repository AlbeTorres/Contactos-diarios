package com.example.eureka.contactosdiarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eureka.contactosdiarios.Fragment.BlankFragment;
import com.example.eureka.contactosdiarios.Pojo.Contacto;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    BlankFragment fragment;
    Spinner spinner;
    List dias = new ArrayList();
    RecyclerView recyclerView;
    ContactoAdapter adapter;
    List<Contacto> contactoList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        fragment = new BlankFragment();

        Caragardatos();

        spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,dias);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ContactoAdapter(this,contactoList);
        recyclerView.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(Main3Activity.this,String.valueOf(spinner.getSelectedItem()),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framecontac,fragment)
                        .commit();
            }
        });






    }

    public  void Caragardatos(){

        dias.add("1");
        dias.add("2");
        dias.add("3");
        dias.add("4");
        dias.add("5");
        dias.add("6");
        dias.add("7");

        contactoList.add(new Contacto(1,"Manolo","55667788",1,4,2020));

    }
}
