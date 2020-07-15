package com.example.aplicacionmercadoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//   - Manuel Herndez Medina                  //
//   - Andrea Laura Oliva                     //
//   - Renato Asalde Silva                    //
//                                            //
////////////////////////////////////////////////

public class PaginaHome extends AppCompatActivity {
    private TextView Bienvenida , Distrito;
    private FirebaseAuth mAuth;
    private DatabaseReference mReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_home);
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();
        Bienvenida = (TextView) findViewById(R.id.Bienvenida);
        Distrito = (TextView) findViewById(R.id.Distrito2);

        // Inicio de el Boton de Navegacion
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // Buscamos el ID de la navegacion
        bottomNavigationView.setSelectedItemId(R.id.Inicio1);
        // ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Inicio1:
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
                        startActivity(new Intent(getApplicationContext(),PaginaJuego.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        getUserInfo();
    }
    private void getUserInfo() {
        String id = mAuth.getCurrentUser().getUid();
        mReference.child("Clientes").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String Nombre = dataSnapshot.child("Nombres").getValue().toString();
                    String Distritos = dataSnapshot.child("Distrito").getValue().toString();
                    Bienvenida.setText("Bienvenido(a) " + Nombre);
                    Distrito.setText(Distritos);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Pulsaciones(View view){
            switch (view.getId()){
                case R.id.SanCamilo:
                    startActivity(new Intent(PaginaHome.this,SanCamilo.class));
                    break;
                case R.id.NuevaEsperanza:
                    startActivity(new Intent(PaginaHome.this,SanCamilo.class));
                    break;
                case R.id.MercadoZamacola:
                    startActivity(new Intent(PaginaHome.this,SanCamilo.class));
                    break;
                case R.id.SanAntonio:
                    startActivity(new Intent(PaginaHome.this,SanCamilo.class));
                    break;
                case R.id.ElPalomar:
                    startActivity(new Intent(PaginaHome.this,SanCamilo.class));
                    break;
                case R.id.LosIncas:
                    startActivity(new Intent(PaginaHome.this,SanCamilo.class));
                    break;
                case R.id.LaChavela:
                    startActivity(new Intent(PaginaHome.this,SanCamilo.class));
                    break;
            }
    }
}