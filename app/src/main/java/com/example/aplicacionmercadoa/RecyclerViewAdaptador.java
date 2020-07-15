package com.example.aplicacionmercadoa;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
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
//                                            //
//                                            //
////////////////////////////////////////////////


public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    Context context;
    TextView cantidad;
    Button verCarro;
    List<ProductoModelo> ProductoLista;
    List<ProductoModelo> CarroCompra;

    public RecyclerViewAdaptador(Context context, TextView cantidad, Button verCarro, List<ProductoModelo> productoLista, List<ProductoModelo> carroCompra) {
        this.context = context;
        this.cantidad = cantidad;
        this.verCarro = verCarro;
        ProductoLista = productoLista;
        CarroCompra = carroCompra;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView Nombre , Descripcion , Precio;
        CheckBox agregarproducto;
        ImageView fotoProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre = (TextView) itemView.findViewById(R.id.tvNombreProducto);
            Descripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
            Precio = (TextView) itemView.findViewById(R.id.tvPrecio);
            fotoProducto = (ImageView) itemView.findViewById(R.id.ImagenProducto);
            agregarproducto = (CheckBox) itemView.findViewById(R.id.CheckBoxAgregar);
        }
    }

    public RecyclerViewAdaptador(List<ProductoModelo> productoLista){
        this.ProductoLista = productoLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_productos,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.Nombre.setText(ProductoLista.get(position).getNombre());
        holder.Descripcion.setText(ProductoLista.get(position).getDescripcion());
        holder.Precio.setText("Precio: S/ "+ProductoLista.get(position).getPrecio() + " nuevos soles x kilo");
        holder.fotoProducto.setImageResource(ProductoLista.get(position).getFotoProducto());

        //EVENTOS

        holder.agregarproducto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(holder.agregarproducto.isChecked() == true) {
                    cantidad.setText(""+(Integer.parseInt(cantidad.getText().toString().trim()) + 1));
                    CarroCompra.add(ProductoLista.get(position));
                    //CarroCompra.add(ProductoLista.get(position));
                } else if(holder.agregarproducto.isChecked() == false) {
                    cantidad.setText(""+(Integer.parseInt(cantidad.getText().toString().trim()) - 1));
                    CarroCompra.remove(ProductoLista.get(position));
                }
            }
        });

        verCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CarroCompra.class);
                intent.putExtra("CarroCompra", (Serializable) CarroCompra);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ProductoLista.size();
    }
}
