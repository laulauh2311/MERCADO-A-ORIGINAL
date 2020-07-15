package com.example.aplicacionmercadoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//   - Manuel Hernandez Medina                //
//                                            //
//                                            //
////////////////////////////////////////////////


public class SanCamiloCarnes extends AppCompatActivity {
    TextView cantidad;
    Button verCarro;

    List<ProductoModelo> Lista = new ArrayList<>();
    List<ProductoModelo> CarroCompra = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerViewAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_camilo_carnes);


        cantidad = (TextView) findViewById(R.id.tvCantProductos);
        verCarro = (Button) findViewById(R.id.VerCarro);

        recyclerView = (RecyclerView) findViewById(R.id.ListadeProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new RecyclerViewAdaptador(SanCamiloCarnes.this,cantidad,verCarro,Lista,CarroCompra);
        recyclerView.setAdapter(adaptador);

        Lista.add(new ProductoModelo("1","Carne de Res", "Carnes",12.00,R.drawable.carnederes));
        Lista.add(new ProductoModelo("2","Filete de Res", "Carnes",10.00,R.drawable.churrasco));
        Lista.add(new ProductoModelo("3","Chuleta de Res", "Carnes",10.00,R.drawable.chuletaderes));
        Lista.add(new ProductoModelo("4","Chuleta de Chancho", "Carnes",13.00,R.drawable.chuletadechancho));
        Lista.add(new ProductoModelo("5","Costillas de Chancho", "Carnes",16.00,R.drawable.costillasdecerdo));
        Lista.add(new ProductoModelo("6","Pollo Entero", "Carnes",8.60,R.drawable.polloentero));
        Lista.add(new ProductoModelo("7","Pechuga de Pollo", "Carnes",5.40,R.drawable.pechugadepollo));

    }

}