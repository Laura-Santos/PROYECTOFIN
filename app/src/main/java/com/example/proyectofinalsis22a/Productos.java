package com.example.proyectofinalsis22a;

public class Productos {
    int codigo;
    String descripcion;
    String autor;
    String tipo;
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Productos() {
    }

    public Productos(int codigo, String descripcion, String autor, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.tipo = tipo;
    }

}



