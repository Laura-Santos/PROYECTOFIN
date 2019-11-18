package com.example.proyectofinalsis22a;


import java.io.Serializable;

//Para enviar objetos entre actividades (Como parámetro) se coloca el "implements Serializable"
public class Dto implements Serializable {

    int codigo;
    String autor;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    String Descripcion;
    String nombre;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public Dto() {
        this.codigo=codigo;
        this.autor = autor;
        String descripcion;
        this.nombre = nombre;
}
}
