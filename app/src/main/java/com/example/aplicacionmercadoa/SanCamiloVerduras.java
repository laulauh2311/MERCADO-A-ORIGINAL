package com.example.aplicacionmercadoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.text.BreakIterator;
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


public class SanCamiloVerduras extends AppCompatActivity {

    TextView cantidad;
    Button verCarro;
    List<ProductoModelo> Lista = new ArrayList<>();
    List<ProductoModelo> CarroCompra = new ArrayList<>();

    private  RecyclerView recyclerView;
    private RecyclerViewAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_camilo_verduras);

        cantidad = (TextView) findViewById(R.id.tvCantProductos);
        verCarro = (Button) findViewById(R.id.VerCarro);


        recyclerView = (RecyclerView) findViewById(R.id.ListadeProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new RecyclerViewAdaptador(SanCamiloVerduras.this,cantidad,verCarro,Lista,CarroCompra);
        recyclerView.setAdapter(adaptador);

        Lista.add(new ProductoModelo("1","Lechuga", "Vegetal",2.00,R.drawable.lechuga));
        Lista.add(new ProductoModelo("2","Zanahoria", "Vegetal",1.00,R.drawable.zanahooria));
        Lista.add(new ProductoModelo("3","Cebolla", "Vegetal",3.00,R.drawable.cebolla));
        Lista.add(new ProductoModelo("4","Tomate", "Vegetal",2.50,R.drawable.tomate));
        Lista.add(new ProductoModelo("5","Papa", "Vegetal",1.00,R.drawable.papa));
        Lista.add(new ProductoModelo("6","Habas", "Vegetal",2.00,R.drawable.habas));
        Lista.add(new ProductoModelo("7","Alverjita", "Vegetal",1.50,R.drawable.alverjita));


    }

}