package com.example.hector.ad3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Estudiantes_por_edad extends AppCompatActivity {
    private MyDBAdapter dbAdapter;
    private Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_por_edad);

        volver=(Button)findViewById(R.id.ad3c_volver_estudiantes_por_edad);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AD3C.class);
                startActivity(i);
            }
        });
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        TextView alumnos_por_edad=(TextView) findViewById(R.id.ad3c__tv_estudiantes_por_edad);
        ArrayList<String> alumnos = dbAdapter.recuperarAlumnosPorEdad();
        alumnos_por_edad.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            Log.d("MIO","Dentro");
            alumnos_por_edad.setText(alumnos_por_edad.getText()+" "+alumnos.get(cont)+"\n");
            Log.d("MIO","set text");

        }

    }
}
