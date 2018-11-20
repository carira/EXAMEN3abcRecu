package com.example.hector.ad3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Asignaturas extends AppCompatActivity {
    private EditText nom;
    private EditText num_est;
    private Button registrar;
    private Button mostrar;
    private Button volver;
    private TextView as_res;

    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        dbAdapter = new MyDBAdapter(this);
        nom=(EditText) findViewById(R.id.as_nom);
        num_est=(EditText) findViewById(R.id.as_n_estudiantes);
        registrar=(Button) findViewById(R.id.b_as_registrar);
        mostrar=(Button) findViewById(R.id.b_as_mostrar);
        volver=(Button) findViewById(R.id.as_volver);
        as_res=(TextView) findViewById(R.id.as_res);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();
                dbAdapter.insertarAsignatura(nom.getText().toString(), num_est.getText().toString());
            }
        });
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbAdapter.open();
                ArrayList<String> asignaturas = dbAdapter.recuperarAsignaturasPorNombre(nom.getText().toString());
                as_res.setText("");
                for(int cont=0;cont<asignaturas.size();cont++){
                    as_res.setText(as_res.getText()+" "+asignaturas.get(cont)+"\n");
                }

            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
