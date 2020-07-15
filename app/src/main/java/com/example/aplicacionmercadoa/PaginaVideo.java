package com.example.aplicacionmercadoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//                                            //
//                                            //
////////////////////////////////////////////////


public class PaginaVideo extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_video);

        MediaController mediaController = new MediaController(this);
        videoView = (VideoView) findViewById(R.id.Video1);
        videoView.setMediaController(mediaController);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/mercado-c7572.appspot.com/o/consejos%20para%20prevenir%20la%20diseminaci%C3%B3n%20del%20coronavirus.mp4?alt=media&token=7af983ad-2c01-4ef4-b4b6-34b4c059bebf");
        videoView.setVideoURI(uri);
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });



        // Inicio de el Boton de Navegacion
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // Buscamos el ID de la navegacion
        bottomNavigationView.setSelectedItemId(R.id.Videos1);
        // ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Inicio1:
                        startActivity(new Intent(getApplicationContext(),PaginaHome.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Buscar1:
                        startActivity(new Intent(getApplicationContext(),PaginaBuscar.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Perfil1:
                        startActivity(new Intent(getApplicationContext(),PaginaPerfil.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Videos1:
                        return true;
                    case R.id.Juego1:
                        startActivity(new Intent(getApplicationContext(),PaginaJuego.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}