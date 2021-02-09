package com.example.eureka.contactosdiarios;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    Animation traslacion,scala;
    TextView testo;
    ImageView ima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        traslacion= AnimationUtils.loadAnimation(this,R.anim.traslacion);
        scala=AnimationUtils.loadAnimation(this,R.anim.expancion);

        testo= (TextView)findViewById(R.id.textView10) ;
        ima= (ImageView) findViewById(R.id.imageView6) ;

        testo.setAnimation(traslacion);
        ima.setAnimation(scala);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent().setClass(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,1500);
    }
}
