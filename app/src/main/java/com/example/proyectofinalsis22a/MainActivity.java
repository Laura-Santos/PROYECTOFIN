package com.example.proyectofinalsis22a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_autor, et_tipo;
    private Button btn_guardar, btn_consultaCodigo, btn_consultaDescripcion, btn_eliminar, btn_actualizar;

    boolean inputEt=false;
    boolean inputEd=false;
    boolean input1=false;
    int resultadoInsert=0;

    String senal = "";
    String codigo = "";
    String descripcion = "";
    String autor = "";
    String tipo = "";

    MantenimientoMySQL manto = new MantenimientoMySQL();
    Dto datos = new Dto();

    //Banderas
    boolean estadoGuarda = false;
    boolean estadoEliminar = false;

    //Alerta
    AlertDialog.Builder dialogo;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_close)
                    .setTitle("Advertencia")
                    .setMessage("¿Realmente desea salir?")
                    .setNegativeButton(android.R.string.cancel, null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.this.finishAffinity();
                        }
                    })
                    .show();
            return true;
        }
        //para las demas cosas, se reenvia el evento al listener habitual
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setTitleTextColor(getResources().getColor(R.color.color1));
        toolbar.setTitleMargin(0, 0, 0, 0);
        toolbar.setSubtitle("Proyecto Final SIS22A");
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.color2));
        toolbar.setTitle("Alabanzas y Coros");
        setSupportActionBar(toolbar);

        ///y esto para pantalla completa (oculta incluso la barra de estado)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        et_codigo = (EditText) findViewById(R.id.et_codigo);
        et_descripcion = (EditText) findViewById(R.id.et_descripcion);
        et_autor = (EditText) findViewById(R.id.et_autor);
        et_tipo = (EditText) findViewById(R.id.et_tipo);
        btn_guardar = (Button) findViewById(R.id.btn_guardar);
        btn_consultaCodigo = (Button) findViewById(R.id.btn_consultaCodigo);
        btn_consultaDescripcion = (Button) findViewById(R.id.btn_consultaDescripcion);
        btn_eliminar = (Button) findViewById(R.id.btn_eliminar);
        btn_actualizar = (Button) findViewById(R.id.btn_eliminar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogConfirmacion();
            }
        });

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {

                senal = bundle.getString("senal");
                codigo = bundle.getString("codigo");
                descripcion = bundle.getString("descripcion");
                autor = bundle.getString("autor");
                tipo = bundle.getString("tipo");
                if (senal.equals("1")) {
                    et_codigo.setText(codigo);
                    et_descripcion.setText(descripcion);
                    et_autor.setText(autor);
                    et_tipo.setText(tipo);
                    //finish();
                }else if(senal.equals("2")){

                }
            }
        }catch (Exception e){

        }

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et_codigo.getText().toString().length()==0){
                    et_codigo.setError("Campo obligatorio");
                    inputEt = false;
                }else {
                    inputEt=true;
                }
                if(et_descripcion.getText().toString().length()==0){
                    et_descripcion.setError("Campo obligatorio");
                    inputEd = false;
                }else {
                    inputEd=true;22
                }
                if(et_autor.getText().toString().length()==0){
                    et_autor.setError("Campo obligatorio");
                    input1 = false;
                }else {
                    input1=true;
                }   if (inputEt && inputEd && input1){
                    String codigo = et_codigo.getText().toString();
                    String descripcion = et_descripcion.getText().toString();
                    String autor = et_autor.getText().toString();
                    String tipo = et_tipo.getText().toString();
                    manto.guardar(MainActivity.this, codigo, descripcion, autor, tipo);

                    limpiarDatos();
                    et_codigo.requestFocus();

                }
            }


        });


        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_codigo.getText().toString().length()==0){
                    et_codigo.setError("campo obligatorio");
                    inputEt = false;
                }else {
                    inputEt=true;
                }

                if(inputEt){
                    String codigo = et_codigo.getText().toString();
                    manto.eliminar(MainActivity.this, codigo);

                    limpiarDatos();
                    et_codigo.requestFocus();

                }
            }
        });

        btn_consultaCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Begin...
                if(et_codigo.getText().toString().length()==0){
                    et_codigo.setError("campo obligatorio");
                    inputEt = false;
                }else {
                    inputEt=true;
                }

