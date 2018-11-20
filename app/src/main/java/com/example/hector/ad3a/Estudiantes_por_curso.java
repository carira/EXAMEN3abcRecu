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

public class Estudiantes_por_curso extends AppCompatActivity {

    private Button buscar;
    private EditText curso;
    private TextView res_estudiantes_por_curso;
    private MyDBAdapter dbAdapter;
    private Button volver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_por_curso);
        res_estudiantes_por_curso = (TextView) findViewById(R.id.res_estudiantes_por_curso);
        buscar=(Button) findViewById(R.id.buscar_estudiantes_por_curso);
        curso=(EditText) findViewById(R.id.ad3_estudiantes_por_curso_filtro);
        volver=(Button)findViewById(R.id.volver_estudiantes_por_curso) ;
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(curso.getText().toString());
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

    private void buscar(String curso){
        Log.d("MIO","buscando");
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        Log.d("MIO","creando arl");
        ArrayList<String> alumnos = dbAdapter.recuperarAlumnosPorCurso(curso);
        Log.d("MIO","set text inicial");
        this.res_estudiantes_por_curso.setText("");
        //textView2.setText(discos.get(1));
        Log.d("MIO","Fuera");
        for(int cont=0;cont<alumnos.size();cont++){
            Log.d("MIO","Dentro");
            res_estudiantes_por_curso.setText(res_estudiantes_por_curso.getText()+" "+alumnos.get(cont)+"\n");
            Log.d("MIO",alumnos.get(cont));

        }
    }
}
