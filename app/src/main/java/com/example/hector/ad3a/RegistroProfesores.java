package com.example.hector.ad3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroProfesores extends AppCompatActivity {
    private Button volver;
    private Button registrar;
    private EditText p_nombre;
    private EditText p_edad;
    private EditText p_ciclo;
    private EditText p_curso;
    private EditText p_despacho;
    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_profesores);

        volver=(Button)findViewById(R.id.p_volver);
        registrar=(Button) findViewById(R.id.p_registrar);
        p_nombre=(EditText) findViewById(R.id.p_nombre);
        p_edad=(EditText) findViewById(R.id.p_edad);
        p_ciclo=(EditText) findViewById(R.id.p_ciclo);
        p_curso=(EditText) findViewById(R.id.p_curso);
        p_despacho=(EditText) findViewById(R.id.p_despacho) ;
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
                dbAdapter.insertarProfesor(p_nombre.getText().toString() , p_edad.getText().toString(), p_ciclo.getText().toString(), p_curso.getText().toString(), p_despacho.getText().toString());
            }
        });
    }
}
