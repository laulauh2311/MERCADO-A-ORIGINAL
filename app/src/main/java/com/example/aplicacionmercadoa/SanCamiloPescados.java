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


public class SanCamiloPescados extends AppCompatActivity {

    TextView cantidad;
    Button verCarro;
    List<ProductoModelo> Lista = new ArrayList<>();
    List<ProductoModelo> CarroCompra = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerViewAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_camilo_pescados);

        cantidad = (TextView) findViewById(R.id.tvCantProductos);
        verCarro = (Button) findViewById(R.id.VerCarro);


        recyclerView = (RecyclerView) findViewById(R.id.ListadeProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new RecyclerViewAdaptador(SanCamiloPescados.this,cantidad,verCarro,Lista,CarroCompra);
        recyclerView.setAdapter(adaptador);

        Lista.add(new ProductoModelo("1","Pez Plata", "Pescados",8.00,R.drawable.pezplata));
        Lista.add(new ProductoModelo("2","Trucha Costera", "Pescados",14.00,R.drawable.truchacostera));
        Lista.add(new ProductoModelo("3","Pejerrey", "Pescados",3.00,R.drawable.pejerrey));
        /*Lista.add(new ProductoModelo("4","Tomate", "Vegetal",2.50,R.drawable.tomate));
        Lista.add(new ProductoModelo("5","Papa", "Vegetal",1.00,R.drawable.papa));
        Lista.add(new ProductoModelo("6","Habas", "Vegetal",2.00,R.drawable.habas));
        Lista.add(new ProductoModelo("7","Alverjita", "Vegetal",1.50,R.drawable.alverjita));*/



    }
}