package com.example.aplicacionmercadoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class PaginaBuscar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_buscar);


        // Inicio de el Boton de Navegacion
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // Buscamos el ID de la navegacion
        bottomNavigationView.setSelectedItemId(R.id.Buscar1);
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
                        return true;
                    case R.id.Perfil1:
                        startActivity(new Intent(getApplicationContext(),PaginaPerfil.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Videos1:
                        startActivity(new Intent(getApplicationContext(),PaginaVideo.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}