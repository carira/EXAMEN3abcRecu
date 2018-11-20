package com.example.hector.ad3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Estudiantes_por_ciclo extends AppCompatActivity {

    private Button buscar;
    private Button volver;
    private EditText nombre;
    private EditText edad;

    private TextView res_estudiantes_por_ciclo;
    private MyDBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_por_ciclo);
        res_estudiantes_por_ciclo = (TextView) findViewById(R.id.res_estudiantes_por_ciclo);
        buscar=(Button) findViewById(R.id.buscarAlumno);
        nombre=(EditText) findViewById(R.id.nombreAlumno);
        edad=(EditText) findViewById(R.id.edadAlumno);
        volver=(Button) findViewById(R.id.volver_estudiantes_por_ciclo);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(nombre.getText().toString(), edad.getText().toString());
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AD3C.class);
                startActivity(i);
            }
        });


    }

    private void buscar(String nombre, String edad){
        Log.d("MIO","buscando");
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        Log.d("MIO","creando arl");
        ArrayList<String> alumnos = dbAdapter.recuperarAlumnosPorEdadyNombre(nombre, edad);
        Log.d("MIO","set text inicial");
        this.res_estudiantes_por_ciclo.setText("");
        //textView2.setText(discos.get(1));
        Log.d("MIO","Fuera");
        for(int cont=0;cont<alumnos.size();cont++){
            Log.d("MIO","Dentro");
            res_estudiantes_por_ciclo.setText(res_estudiantes_por_ciclo.getText()+" "+alumnos.get(cont)+"\n");
            Log.d("MIO",alumnos.get(cont));

        }
    }
}
