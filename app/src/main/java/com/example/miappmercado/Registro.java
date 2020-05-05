package com.example.miappmercado;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.miappmercado.ui.login.LoginActivity;

public class Registro extends AppCompatActivity {

    Spinner distritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        distritos = (Spinner)findViewById(R.id.sp01);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Distritos,android.R.layout.simple_selectable_list_item);
        distritos.setAdapter(adapter);
    }
    public void PrincipalMercado(View View) {
        Intent i = new Intent(Registro.this , PrincipalMercado.class);
        startActivity(i);
    }
    public void MercadoPrincipal(View View) {
        Intent i = new Intent(Registro.this , MercadoPrincipal.class);
        startActivity(i);
    }

}
