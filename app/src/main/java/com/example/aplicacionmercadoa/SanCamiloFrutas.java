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


public class SanCamiloFrutas extends AppCompatActivity {

    TextView cantidad;
    Button verCarro;
    List<ProductoModelo> Lista = new ArrayList<>();
    List<ProductoModelo> CarroCompra = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerViewAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_camilo_frutas);

        cantidad = (TextView) findViewById(R.id.tvCantProductos);
        verCarro = (Button) findViewById(R.id.VerCarro);


        recyclerView = (RecyclerView) findViewById(R.id.ListadeProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new RecyclerViewAdaptador(SanCamiloFrutas.this,cantidad,verCarro,Lista,CarroCompra);
        recyclerView.setAdapter(adaptador);

        Lista.add(new ProductoModelo("1","Manzana", "Fruta",4.00,R.drawable.manzana));
        Lista.add(new ProductoModelo("2","Uva Italia", "Fruta",5.00,R.drawable.uva));
        Lista.add(new ProductoModelo("3","Platano", "Fruta",3.00,R.drawable.platano));
        Lista.add(new ProductoModelo("4","Sandia Entera", "Fruta",1.00,R.drawable.sandia));
        Lista.add(new ProductoModelo("5","Granadilla", "Fruta",1.00,R.drawable.granadilla));
        Lista.add(new ProductoModelo("6","Fresa", "Fruta",2.00,R.drawable.fresa));
        Lista.add(new ProductoModelo("7","Piña", "Fruta",1.50,R.drawable.pinia));


    }
}