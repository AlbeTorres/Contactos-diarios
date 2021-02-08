package com.example.eureka.contactosdiarios;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
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

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;


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
    int inputcode2=18;
    int dia;
    int mes;
    int año;
    Acceso acceso;
    Contacto contactop;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){

            nombre= data.getStringExtra("nombre");
            telefono= data.getStringExtra("tele");

            Contacto contacto= new Contacto(1,nombre,telefono,dia,mes,año);

            long result =acceso.InsertarDatos(contacto);

            acceso.CargarDatos(dia,mes,año,contactoList);



            recyclerView.setAdapter(adapter);


            getSupportFragmentManager()
                    .beginTransaction()
                    .hide(fragment)
                    .commit();

        }

        if(resultCode==52){

            nombre= data.getStringExtra("nombre");
            telefono= data.getStringExtra("tele");

            Contacto contacto= new Contacto(contactop.getId(),nombre,telefono,dia,mes,año);

            long result =acceso.ModificarDatos(contacto,contactop.getId());

            acceso.CargarDatos(dia,mes,año,contactoList);


            recyclerView.setAdapter(adapter);

        }


    }


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

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
            dia = today.monthDay;
            mes = (today.month) +1;
            año = today.year;

            acceso= new Acceso(this);


        acceso.CargarDatos(dia,mes,año,contactoList);

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
        intent2.putExtra("dia",dia);
        intent2.putExtra("mes",mes);
        intent2.putExtra("año",año);


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



    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            int position = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:
                    acceso.EliminarDatos(contactoList.get(position).getId());
                    contactoList.remove(position);
                    adapter.notifyItemRemoved(position);

                    if (contactoList.isEmpty()){

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame,fragment)
                                .show(fragment)
                                .commit();
                    }

                    break;
                case ItemTouchHelper.RIGHT:
                    contactop= contactoList.get(position);
                    Intent intent3 = new Intent(MainActivity.this,Main5Activity.class);
                    intent3.putExtra("Nom",contactop.getNombre());
                    intent3.putExtra("Tel",contactop.getTelefono());
                    recyclerView.setAdapter(adapter);
                    startActivityForResult(intent3,inputcode2);
                    break;

            }

        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                float dX, float dY, int actionState, boolean isCurrentlyActive) {

           new RecyclerViewSwipeDecorator.Builder(MainActivity.this,c,recyclerView,viewHolder,dX,dY,actionState,isCurrentlyActive)
                   .addSwipeLeftBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.red))
                   .addSwipeLeftActionIcon(R.mipmap.ic_deleted)
                   .addSwipeRightBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.verde))
                   .addSwipeRightActionIcon(R.mipmap.ic_edit)
                   .create()
                   .decorate();


            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dir,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sobre_nosotros:

                Intent acerca = new Intent(MainActivity.this,Main6Activity.class);
                startActivity(acerca);


            default:
                return super.onOptionsItemSelected(item);
    }

    }
}

