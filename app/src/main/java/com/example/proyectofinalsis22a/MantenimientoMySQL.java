package com.example.proyectofinalsis22a;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class MantenimientoMySQL {
//Objeto
Dto datos = new Dto();

    boolean estadoGuardar = false;
    boolean estadoEliminar = false;

    private ProgressDialog pd;
    AlertDialog.Builder dialogo1;
    AlertDialog.Builder dialogo;
    ProgressDialog progressDialog;

    ProductsAdapter adapter;

    public void guardar(final Context context, final String codigo, final String descripcion, final String autor, final String tipo){
        String url = Config.urlGuardar;
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{
                            JSONObject requestJSON = new JSONObject(response.toString());
                            String estado = requestJSON.getString("estado");
                            String mensaje = requestJSON.getString("mensaje");

                            if(estado.equals("1")){
                                Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                                //Toast.makeText(context, "Registro almacenado en MySQL.", Toast.LENGTH_SHORT).show();
                            }else if(estado.equals("2")){
                                Toast.makeText(context, ""+mensaje, Toast.LENGTH_SHORT).show();
                                   }

                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "No se puedo guardar. \n" +
                        "Verifique su acceso a internet.", Toast.LENGTH_SHORT).show();
            }
        }){
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> map = new HashMap<>();
            map.put("Content-Type", "application/json; charset=utf-8");
            map.put("Accept", "application/json");
            map.put("codigo", codigo);
            map.put("descripcion", descripcion);
            map.put("autor", autor);
            map.put("tipo", tipo);
            return map;
        }
    };
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public boolean guardar1(final Context context, final String codigo, final String descripcion, final String autor, final String tipo) {
        // String url = "http://mjgl.com.sv/mysqlcrud/guardar.php";
        String url  = Config.urlGuardar;
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject requestJSON = new JSONObject(response.toString());
                            String estado = requestJSON.getString("estado");
                            String mensaje = requestJSON.getString("mensaje");

                            if (estado.equals("1")) {
                                //Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                                estadoGuardar = true;
                            } else if (mensaje.equals("2")) {
                                Toast.makeText(context, "Error. No se pudo guardar.\n" +
                                        "Intentelo mas tarde.", Toast.LENGTH_SHORT).show();
                                estadoGuardar = false;
                            }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        //Toast.makeText(context, "Se encontrarón problemas...", Toast.LENGTH_SHORT).show();
                        estadoGuardar = false;
                    }

                }

   public void consultarCodigo(final Context context, final String codigo){
    progressDialog = new ProgressDialog(context);
    progressDialog.setCancelable(false);
    progressDialog.setMessage("Espere por favor, Estamos trabajando en su petición en el servidor");
    progressDialog.show();

     String url  = Config.urlConsultaCodigo;

     StringRequest stringRequest = new StringRequest(Request.Method.POST,
         url,
       new Response.Listener<String>() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @SuppressLint("ResourceType")
        @Override
        public void onResponse(String response) {
          if(response.equals("0")) {
          Toast.makeText(context, "No se encontrarón resultados para la búsqueda especificada.", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
           }else{
           try {

         JSONArray jsonArray = new JSONArray(response);
         String codigo = jsonArray.getJSONObject(0).getString("codigo");
         String descripcion = jsonArray.getJSONObject(0).getString("descripcion");
         String autor = jsonArray.getJSONObject(0).getString("autor");
         String tipo = jsonArray.getJSONObject(0).getString("tipo");



         Intent intent = new Intent(context, MainActivity.class);
         intent.putExtra("senal", "1");
         intent.putExtra("codigo", codigo.toString());
         intent.putExtra("descripcion", descripcion);
         intent.putExtra("autor", autor);
         intent.putExtra("tipo", tipo);
         context.startActivity(intent);


            progressDialog.dismiss();
            } catch (JSONException e) {
              e.printStackTrace();
              }
         }
      progressDialog.dismiss();
          }
          },
      new Response.ErrorListener() {
       @Override
        public void onErrorResponse(VolleyError error) {
        if(error != null){
          Toast.makeText(context, "No se ha podido establecer conexión con el servidor. Verifique su acceso a Internet.", Toast.LENGTH_LONG).show();
           progressDialog.dismiss();
         }
       }
     }) {
     protected Map<String, String> getParams() throws AuthFailureError {
       Map<String, String> map = new HashMap<String, String>();
       map.put("codigo",codigo);
       return map;
                    }
            };

         MySingleton.getInstance(context).addToRequestQueue(stringRequest);

      }

 public void consultarDescripcion(final Context context, final String descripcion){

     progressDialog = new ProgressDialog(context);
     progressDialog.setCancelable(false);
     progressDialog.setMessage("Espere por favor, Estamos trabajando en su petición en el servidor");
     progressDialog.show();
     String url  = Config.urlbuscarhimnario;

     StringRequest stringRequest = new StringRequest(Request.Method.POST,
             url,
             new Response.Listener<String>() {
                 @RequiresApi(api = Build.VERSION_CODES.M)
                 @SuppressLint("ResourceType")
                 @Override
                 public void onResponse(String response) {
                     if(response.equals("0")) {
                         Toast.makeText(context, "No se encontrarón resultados para la búsqueda especificada.", Toast.LENGTH_SHORT).show();
                         progressDialog.dismiss();
                     }else{
                         try {

                             JSONArray jsonArray = new JSONArray(response);
                             String codigo = jsonArray.getJSONObject(0).getString("codigo");
                             String descripcion = jsonArray.getJSONObject(0).getString("descripcion");
                             String autor = jsonArray.getJSONObject(0).getString("autor");
                             String tipo = jsonArray.getJSONObject(0).getString("tipo");

                             datos.setCodigo(Integer.parseInt(codigo));
                             datos.setDescripcion(descripcion);
                             datos.setAutor(autor);
                             datos.setTipo(tipo);

                             Intent intent = new Intent(context, MainActivity.class);
                             intent.putExtra("senal", "1");
                             intent.putExtra("codigo", codigo.toString());
                             intent.putExtra("descripcion", descripcion);
                             intent.putExtra("autor", autor);
                             intent.putExtra("tipo", tipo);


                             context.startActivity(intent);

                             progressDialog.dismiss();

                         } catch (JSONException e) {
                             e.printStackTrace();
                         }
                     }
                     progressDialog.dismiss();
                 }
             },


 }


  }




