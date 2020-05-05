package com.example.miappmercado;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.miappmercado.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;
    private static int splashTimeOut=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = (ImageView)findViewById(R.id.imageView);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);
        logo.startAnimation(anim);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(i);
            }
        },splashTimeOut);
    }
}