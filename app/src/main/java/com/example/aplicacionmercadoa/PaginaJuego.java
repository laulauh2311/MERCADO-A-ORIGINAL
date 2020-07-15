package com.example.aplicacionmercadoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//   - Manuel Herndez Medina                  //
//   - Andrea Laura Oliva                     //
//   - Renato Asalde Silva                    //
//                                            //
////////////////////////////////////////////////


public class PaginaJuego extends AppCompatActivity {
    Button juego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_juego);
        juego = (Button) findViewById(R.id.JuegoMemorama);

        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NivelesMemorama.class));
            }
        });

        // Inicio de el Boton de Navegacion
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // Buscamos el ID de la navegacion
        bottomNavigationView.setSelectedItemId(R.id.Juego1);
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
                        startActivity(new Intent(getApplicationContext(),PaginaVideo.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Juego1:
                        return true;
                }
                return false;
            }
        });


    }
}