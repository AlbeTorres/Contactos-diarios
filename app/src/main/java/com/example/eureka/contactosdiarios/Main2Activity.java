package com.example.eureka.contactosdiarios;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    TextView nombre;
    TextView telefono;
    AutoCompleteTextView nombre1;
    AutoCompleteTextView telefono1;
    Button añadir;
    Intent intent;
    List<String> nombres = new ArrayList<>();
    ImageButton imageButton;
    Acceso acceso;
    List<String> tele = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        toolbar2.setTitle("Añadir contacto");
        setSupportActionBar(toolbar2);

        acceso = new Acceso(this);

        nombre= (TextView) findViewById(R.id.textViewnombre);
        telefono= (TextView) findViewById(R.id.textView2);
        nombre1= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        telefono1= (AutoCompleteTextView) findViewById(R.id.editex);
        añadir= (Button) findViewById(R.id.añafra);
        imageButton= (ImageButton) findViewById(R.id.imageButton);

        intent = new Intent(Main2Activity.this,MainActivity.class);


        Cargardatos();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nombres);
        nombre1.setThreshold(1);
        nombre1.setAdapter(adapter);


        ArrayAdapter<String> adaptertele = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,tele);
        telefono1.setThreshold(1);
        telefono1.setAdapter(adaptertele);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cont = new Intent(Intent.ACTION_PICK);
                cont.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(cont,22);

            }
        });


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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==22 && resultCode== RESULT_OK){

            Uri uri = data.getData();
            Cursor cursor = getContentResolver().query(uri,null,null,null,null);

            if (cursor != null && cursor.moveToFirst()){

                int indicename= cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                int indicenumber= cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

                String auxnombre =cursor.getString(indicename);
                String auxtelefono =cursor.getString(indicenumber);

                auxtelefono= auxtelefono.replace("(","").replace(")","").replace(" ","")
                           .replace("+","").replace("-","");

                nombre1.setText(auxnombre);
                telefono1.setText(auxtelefono);
            }
        }
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
