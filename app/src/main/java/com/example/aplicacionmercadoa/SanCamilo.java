package com.example.aplicacionmercadoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//   - Manuel Herndez Medina                  //
//   - Andrea Laura Oliva                     //
//   - Renato Asalde Silva                    //
//                                            //
////////////////////////////////////////////////


public class SanCamilo extends AppCompatActivity {
    private ConstraintLayout verduras,carnes,frutas,pescados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_camilo);
        verduras = (ConstraintLayout)findViewById(R.id.SC_SeccionVerduras);
        carnes = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        frutas = (ConstraintLayout) findViewById(R.id.constraintLayout4);
        pescados= (ConstraintLayout) findViewById(R.id.constraintLayout5);


        verduras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SanCamilo.this,SanCamiloVerduras.class));
            }
        });
        carnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SanCamilo.this,SanCamiloCarnes.class));
            }
        });

        frutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SanCamilo.this,SanCamiloFrutas.class));
            }
        });

        pescados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SanCamilo.this,SanCamiloPescados.class));
            }
        });



    }
}