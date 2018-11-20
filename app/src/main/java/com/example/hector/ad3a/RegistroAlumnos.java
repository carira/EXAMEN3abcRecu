package com.example.hector.ad3a;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistroAlumnos extends AppCompatActivity {

    private Button volver;
    private Button registrar;
    private EditText a_nombre;
    private EditText a_edad;
    private EditText a_ciclo;
    private EditText a_curso;
    private MyDBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumnos);
        volver=(Button)findViewById(R.id.a_volver);
        registrar=(Button) findViewById(R.id.a_registrar);
        a_nombre=(EditText) findViewById(R.id.a_nombre);
        a_edad=(EditText) findViewById(R.id.a_edad);
        a_ciclo=(EditText) findViewById(R.id.a_ciclo);
        a_curso=(EditText) findViewById(R.id.a_curso);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AD3B.class);
                startActivity(i);
            }
        });

        dbAdapter = new MyDBAdapter(this);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();
                dbAdapter.insertarAlumno(a_nombre.getText().toString() , a_edad.getText().toString(), a_ciclo.getText().toString(), a_curso.getText().toString());
            }
        });
    }
}
