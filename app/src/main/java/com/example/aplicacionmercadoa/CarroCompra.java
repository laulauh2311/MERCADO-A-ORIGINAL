package com.example.aplicacionmercadoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.List;

/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//   - Manuel Herndez Medina                  //
//   - Andrea Laura Oliva                     //
//   - Renato Asalde Silva                    //
//                                            //
////////////////////////////////////////////////

public class CarroCompra extends AppCompatActivity {

    List<ProductoModelo> carroCompra;
    AdaptadorCarroCompras adaptador;
    RecyclerView recyclerView;
    TextView tvTotal;
    Button generar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_compra);
        carroCompra = (List<ProductoModelo>) getIntent().getSerializableExtra("CarroCompra");
        recyclerView = (RecyclerView) findViewById(R.id.rvListaCarro);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tvTotal = findViewById(R.id.tvTotal);

        adaptador = new AdaptadorCarroCompras(CarroCompra.this,carroCompra, tvTotal);
        recyclerView.setAdapter(adaptador);


        generar = (Button) findViewById(R.id.GenerarPedido);


    }

    public void GenerarCompra(View View){
        startActivity(new Intent(CarroCompra.this,GenerarCompra.class));
    }
}