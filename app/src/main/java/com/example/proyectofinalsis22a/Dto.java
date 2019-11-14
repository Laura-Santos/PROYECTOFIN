package com.example.proyectofinalsis22a;


import java.io.Serializable;

//Para enviar objetos entre actividades (Como parámetro) se coloca el "implements Serializable"
public class Dto implements Serializable {

    int codigo;
    String descripcion;
    String autor;
    String tipo;
}
