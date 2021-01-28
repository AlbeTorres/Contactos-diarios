package com.example.eureka.contactosdiarios;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eureka.contactosdiarios.Database.Acceso;
import com.example.eureka.contactosdiarios.Database.Constants;
import com.example.eureka.contactosdiarios.Database.Database;
import com.example.eureka.contactosdiarios.Fragment.Imagen;
import com.example.eureka.contactosdiarios.Pojo.Contacto;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Fragment fragment = new Imagen();;
    Toolbar toolbar;
    RecyclerView recyclerView;
    List<Contacto> contactoList = new ArrayList<>();
    ContactoAdapter adapter;
    Button añadir;
    Button contacto;
    Intent intent;
    Intent intent2;
    String nombre, telefono;
    int inputcode= 17;
    int dia;
    int mes;
    int año;
    Acceso acceso;
    Database db= new Database(this);



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){

            nombre= data.getStringExtra("nombre");
            telefono= data.getStringExtra("tele");

            Contacto contacto= new Contacto(1,nombre,telefono,dia,mes,año);

            long result =InsertarDatos(contacto);

            CargarDatos(dia);

            Toast.makeText(MainActivity.this,""+ result,Toast.LENGTH_LONG).show();

            recyclerView.setAdapter(adapter);


            getSupportFragmentManager()
                    .beginTransaction()
                    .hide(fragment)
                    .commit();

        } }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        añadir = (Button) findViewById(R.id.aña);
        contacto = (Button) findViewById(R.id.cont);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ContactoAdapter(this,contactoList);


        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
            dia = today.monthDay;
            mes = (today.month) +1;
            año = today.year;


        CargarDatos(dia);

        if (contactoList.isEmpty()){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame,fragment)
                    .commit();
             } else{

            recyclerView.setAdapter(adapter);
        }




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
            public void onClick(View v) {startActivityForResult(intent,inputcode);

            }
        });

    }




    public void CargarDatos(Integer diase){



        SQLiteDatabase database = db.getReadableDatabase();

        Cursor cur = database.rawQuery("SELECT * FROM "+ Constants.TABLE_CONTACTO + " WHERE " + Constants.DIA + "=" + diase,null);

        if( cur.moveToFirst()){

            /*cur != null*/

            do{

                contactoList.add(new Contacto(         cur.getInt(0),cur.getString(1),
                                                    cur.getString(2),cur.getInt(3),
                                                    cur.getInt(4),cur.getInt(5)
                                              ));
            } while(cur.moveToNext());


        }



    }


    public long InsertarDatos(Contacto contacto){

        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.NOMBRE,contacto.getNombre());
        contentValues.put(Constants.TELEFONO,contacto.getTelefono());
        contentValues.put(Constants.DIA,contacto.getDia());
        contentValues.put(Constants.MES,contacto.getMes());
        contentValues.put(Constants.AÑO,contacto.getAño());

        long resul= database.insert(Constants.TABLE_CONTACTO,null,contentValues);

        database.close();

        return resul;
    }


    public List<Contacto> Car(){

        List<Contacto> con = new ArrayList<>();

        con.add(new Contacto(1,"ee","rr",1,1,1));
        con.add(new Contacto(1,"ee","rr",1,1,1));
        con.add(new Contacto(1,"ee","rr",1,1,1));
        con.add(new Contacto(1,"ee","rr",1,1,1));

        return con;

    }
}
