package com.example.proyectofinalsis22a;


import java.io.Serializable;

//Para enviar objetos entre actividades (Como parámetro) se coloca el "implements Serializable"
public class Dto implements Serializable {

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

    public Dto() {

    }

  //constructor
  public Dto(int codigo, String descripcion, String autor, String tipo) {

  }
}
