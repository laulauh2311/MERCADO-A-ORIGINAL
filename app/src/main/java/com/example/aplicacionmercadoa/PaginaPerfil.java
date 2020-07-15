package com.example.aplicacionmercadoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
//                                            //
//                                            //
////////////////////////////////////////////////

public class PaginaPerfil extends AppCompatActivity {
    private EditText NombredePerfil , ApellidodePerfil , CorreodePerfil , TelefonoPerfil , DistritodePerfil;
    private FirebaseAuth mAuth;
    private DatabaseReference mReference;
    Button cerrarsesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_perfil);
        NombredePerfil = (EditText)findViewById(R.id.NombrePerfil);
        ApellidodePerfil = (EditText)findViewById(R.id.ApellidosPerfil);
        CorreodePerfil = (EditText)findViewById(R.id.CorreoPerfil);
        TelefonoPerfil = (EditText)findViewById(R.id.TelefonoPerfil);
        DistritodePerfil = (EditText)findViewById(R.id.DistritoPerfil);
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();
        cerrarsesion = (Button)findViewById(R.id.CerrarSesionCliente);

        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PaginaPerfil.this);
                builder.setTitle("Cerrar Sesion");
                builder.setMessage("¿ Seguro que quiere salir de la aplicación ?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAuth.signOut();
                        Intent i = new Intent(PaginaPerfil.this , LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
               builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               });
                Dialog dialog = builder.create();
                dialog.show();
            }
        });

        MostrarUserInfo();


        // Inicio de el Boton de Navegacion
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // Buscamos el ID de la navegacion
        bottomNavigationView.setSelectedItemId(R.id.Perfil1);
        // ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.Inicio1:
                        startActivity(new Intent(getApplicationContext(),PaginaHome.class));
                        return true;
                    case R.id.Buscar1:
                        startActivity(new Intent(getApplicationContext(),PaginaBuscar.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Perfil1:
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
    }

    private void MostrarUserInfo() {
        String id = mAuth.getCurrentUser().getUid();
        mReference.child("Clientes").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String Nombre = dataSnapshot.child("Nombres").getValue().toString();
                    String Apellidos = dataSnapshot.child("Apellidos").getValue().toString();
                    String CorreoElectronico = dataSnapshot.child("Correo Electronico").getValue().toString();
                    String TelefonoCelular = dataSnapshot.child("Telefono Celular").getValue().toString();
                    String DistritosPerfil = dataSnapshot.child("Distrito").getValue().toString();
                    //String Direccion = dataSnapshot.child("Direccion").getValue().toString();

                    NombredePerfil.setText(Nombre);
                    ApellidodePerfil.setText(Apellidos);
                    CorreodePerfil.setText(CorreoElectronico);
                    TelefonoPerfil.setText(TelefonoCelular);
                    DistritodePerfil.setText(DistritosPerfil);
                    //DireccionPerfil.setText(Direccion);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}