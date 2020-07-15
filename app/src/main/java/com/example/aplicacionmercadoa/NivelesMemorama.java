package com.example.aplicacionmercadoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//   - Manuel Hernandez Medina                //
//                                            //
//                                            //
////////////////////////////////////////////////


public class NivelesMemorama extends AppCompatActivity {
    private Button facil , intermedio , dificil ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles_memorama);
        facil = (Button)findViewById(R.id.NivelFacil);
        intermedio = (Button) findViewById(R.id.NivelIntermedio);
        dificil = (Button) findViewById(R.id.NivelDificil);

        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NivelesMemorama.this , MemoNivelFacil.class);
                startActivity(i);
            }
        });

        intermedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NivelesMemorama.this , Memo_Nivel_Intermedio.class);
                startActivity(i);
            }
        });

        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NivelesMemorama.this , MemoNivelDificil.class);
                startActivity(i);
            }
        });

    }
}