package com.example.eureka.contactosdiarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    Button mostrar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar4 = (Toolbar) findViewById(R.id.toolbar4);
        toolbar4.setTitle("Selecciona una fecha");
        setSupportActionBar(toolbar4);

        intent = new Intent(Main4Activity.this,Main3Activity.class);

        mostrar= (Button) findViewById(R.id.mostrar);


        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,intent);
                finish();
            }
        });




    }
}
