package com.example.eureka.contactosdiarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Toolbar toolbar3;
    int dia ;
    int mes;
    int año;
    Button sele;
    Intent intent3;
    int inputcode= 17;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){


            getSupportFragmentManager()
                    .beginTransaction()
                    .hide(fragment)
                    .commit();

        } }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        toolbar3 = (Toolbar) findViewById(R.id.toolbar3);
        toolbar3.setTitle("Últimos contactos");
        setSupportActionBar(toolbar3);

        sele = (Button)findViewById(R.id.sele);
        intent3 = new Intent(this,Main4Activity.class);

        fragment = new BlankFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framecontac,fragment)
                .commit();



        recyclerView= (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ContactoAdapter(this,contactoList);
        recyclerView.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();
         dia = bundle.getInt("dia");
         mes= bundle.getInt("mes");
         año= bundle.getInt("año");



        sele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent3,inputcode);
            }
        });




    }

}
