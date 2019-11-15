package com.example.proyectofinalsis22a;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Consulta_RecyclerView {
    //private static final String URL = "http://mjgl.com.sv/mysqlcrud/Api.php";
    private static final String URL = Config.urlConsultaApiMySQLi;

    List<Productos> productosList;
    RecyclerView recyclerView;

    ProductsAdapter adapter;

    AlertDialog.Builder dialogo;
}
