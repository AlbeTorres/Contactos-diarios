package com.example.eureka.contactosdiarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    Button mostrar;
    Intent intent;
    DatePicker datePicker;
    int diapick;
    int mespick;
    int añopick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar4 = (Toolbar) findViewById(R.id.toolbar4);
        toolbar4.setTitle("Selecciona una fecha");
        setSupportActionBar(toolbar4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        datePicker = (DatePicker) findViewById(R.id.datePicker);

        intent = new Intent(Main4Activity.this,Main3Activity.class);

        mostrar= (Button) findViewById(R.id.mostrar);

        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        final int dia = today.monthDay;
        final int mes = (today.month) +1;
        final int año = today.year;



        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diapick= datePicker.getDayOfMonth();
                mespick= datePicker.getMonth()+1;
                añopick= datePicker.getYear();


                if (    (( diapick <= dia )&&( mespick <= mes )&&( añopick<= año ))||
                        (( diapick > dia )&&( mespick < mes )&&( añopick<= año ))||
                        (( diapick > dia )&&( mespick > mes )&&( añopick< año ))||
                        (( diapick < dia )&&( mespick > mes )&&( añopick < año ))



                        ){

                    intent.putExtra("diapi",diapick);
                    intent.putExtra("mespi",mespick);
                    intent.putExtra("añopi",añopick);
                    setResult(RESULT_OK,intent);
                    finish();

                }else {

                   Toast.makeText(Main4Activity.this,"Selecciona una fecha anterior a la actual",Toast.LENGTH_LONG).show();



                }


            }
        });




    }
}
