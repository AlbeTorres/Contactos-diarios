package com.example.eureka.contactosdiarios.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eureka on 27/01/2021.
 */

public class Database extends SQLiteOpenHelper {

    Context context;


    public Database(Context context)  {
        super(context, Constants.DATABASE_NAME,null, Constants.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaContacto= "CREATE TABLE "+ Constants.TABLE_CONTACTO + "("+
                Constants.ID_CONTACTO        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.NOMBRE    + " TEXT, " +
                Constants.TELEFONO + " TEXT, " +
                Constants.DIA + " INTEGER, " +
                Constants.MES      + " INTEGER, " +
                Constants.AÑO      + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaContacto);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_CONTACTO);

    }
}
