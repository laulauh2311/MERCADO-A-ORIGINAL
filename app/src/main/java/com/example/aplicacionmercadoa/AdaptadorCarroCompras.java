package com.example.aplicacionmercadoa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.Serializable;
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

public class AdaptadorCarroCompras extends RecyclerView.Adapter<AdaptadorCarroCompras.ProductosViewHolder> {

    Context context;
    TextView tvTotal;
    List<ProductoModelo> carroCompra;
    double total=0;

    public AdaptadorCarroCompras(Context context, List<ProductoModelo> carroCompra,TextView tvTotal) {
        this.context = context;
        this.carroCompra = carroCompra;
        this.tvTotal = tvTotal;
        for(int i = 0 ; i < carroCompra.size();i++){
            total = total + Double.parseDouble(""+carroCompra.get(i).getPrecio());
        }
        tvTotal.setText("TOTAL: S/."+ total +" "+"nuevos soles");


        String  totalpago = toString().valueOf(total);

        //Bundle extras = new Bundle();
        //extras.putString("Total",totalpago);

        Intent intent = new Intent(context,GenerarCompra.class);
        intent.putExtra("Total",totalpago);

    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_carro_compras,null,false);
        return new AdaptadorCarroCompras.ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductosViewHolder holder, final int position) {
        holder.tvNombreProducto.setText(carroCompra.get(position).getNombre());
        holder.tvDescription.setText(carroCompra.get(position).getDescripcion());
        holder.tvPrecio.setText("Precio: S/ "+ carroCompra.get(position).getPrecio() + " nuevo soles");
        holder.fotoProducto.setImageResource(carroCompra.get(position).getFotoProducto());

    }



    @Override
    public int getItemCount() {
        return carroCompra.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder{
        TextView tvNombreProducto , tvDescription, tvPrecio;
        ImageView fotoProducto;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreProducto = itemView.findViewById(R.id.tvNombreProducto);
            tvDescription = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            fotoProducto = (ImageView) itemView.findViewById(R.id.ImagenCarroCompras);

        }
    }
}
