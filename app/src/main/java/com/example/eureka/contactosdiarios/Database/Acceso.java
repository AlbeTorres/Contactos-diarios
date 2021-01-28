package com.example.eureka.contactosdiarios.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.eureka.contactosdiarios.Pojo.Contacto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eureka on 28/01/2021.
 */

public class Acceso {

    private Context context;


   public Acceso(Context context){
       this.context = context;
   }

    Database db= new Database(context);


    public List<Contacto> CargarDatos(){

        List<Contacto> contactolist = new ArrayList<>();


        SQLiteDatabase database = db.getReadableDatabase();

        Cursor cur = database.rawQuery("SELECT * FROM "+ Constants.TABLE_CONTACTO,null);

        if( cur.moveToFirst()){

            /*cur != null*/

            do{

                contactolist.add(new Contacto(  cur.getInt(0),cur.getString(1),
                                                cur.getString(2),cur.getString(3),
                                                cur.getString(4),cur.getString(5)
                                                ));
            } while(cur.moveToNext());


        }



        return contactolist;

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

    public long ModificarDatos(Contacto contacto, Integer id){


        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.NOMBRE,contacto.getNombre());
        contentValues.put(Constants.TELEFONO,contacto.getTelefono());
        contentValues.put(Constants.DIA,contacto.getDia());
        contentValues.put(Constants.MES,contacto.getMes());
        contentValues.put(Constants.AÑO,contacto.getAño());

        long result = database.update( Constants.TABLE_CONTACTO, contentValues, Constants.ID_CONTACTO + "=" + id,null);
        database.close();
        return result;
    }

    public long EliminarDatos(Integer id){
        SQLiteDatabase database = db.getWritableDatabase();

        long result = database.delete(Constants.TABLE_CONTACTO , Constants.ID_CONTACTO + "=" + id,null);

        return result;
    }

    public Contacto ConsultarContacto(Integer id){

        Contacto contacto;

        SQLiteDatabase database = db.getReadableDatabase();

        Cursor cur = database.rawQuery("SELECT * FROM "+ Constants.TABLE_CONTACTO + " WHERE " + Constants.ID_CONTACTO + "=" + id,null);

        cur.moveToFirst();

        contacto = new Contacto(    cur.getInt(0),cur.getString(1),
                                    cur.getString(2),cur.getString(3),
                                    cur.getString(4),cur.getString(5)
                                );

        return contacto;
    }

    }






