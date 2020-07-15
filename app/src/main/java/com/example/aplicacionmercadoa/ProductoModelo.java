package com.example.aplicacionmercadoa;

import android.os.Parcelable;

import java.io.Serializable;

/////////////////////////////////////////////////
//   Programadores de Codigo:                 //
//                                            //
//   - Alvaro Berrios Zuniga                  //
//                                            //
//                                            //
////////////////////////////////////////////////



public class ProductoModelo implements Serializable {
    private String idProducto;
    private String Nombre;
    private String Descripcion;
    private double precio;
    private int fotoProducto;

    public ProductoModelo(){

    }

    public ProductoModelo(String idProducto, String nombre, String descripcion, double precio, int fotoProducto) {
        this.idProducto = idProducto;
        Nombre = nombre;
        Descripcion = descripcion;
        this.precio = precio;
        this.fotoProducto = fotoProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(int fotoProducto) {
        this.fotoProducto = fotoProducto;
    }
}
