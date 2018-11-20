package com.example.hector.ad3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class AD3C extends AppCompatActivity {

    private Button todos_los_estudiantes;
    private Button estudiantes_por_ciclos;
    private Button estudiantes_por_cursos;
    private Button todos_los_profesores;
    private Button todos_los_profesores_y_estudiantes;
    private Button todos_los_estudiantes_entre_20_y_25;

    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad3_c);
        todos_los_estudiantes=(Button)findViewById(R.id.ad3c_todos_los_estudiantes);
        estudiantes_por_ciclos=(Button) findViewById(R.id.ad3c_estudiantes_por_ciclo) ;
        estudiantes_por_cursos=(Button) findViewById(R.id.ad3c_estudiantes_por_curso);
        todos_los_profesores=(Button) findViewById(R.id.ad3c_todos_los_profesores);
        todos_los_profesores_y_estudiantes=(Button) findViewById(R.id.todos);
        todos_los_estudiantes_entre_20_y_25=(Button) findViewById(R.id.ad3c_todos_los_estudiantes_por_edad) ;
        volver=(Button) findViewById(R.id.ad3c_volver) ;

        todos_los_estudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Todos_los_estudiantes.class);
                startActivity(i);
            }
        });
        estudiantes_por_ciclos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Estudiantes_por_ciclo.class);
                startActivity(i);
            }
        });
        estudiantes_por_cursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Estudiantes_por_curso.class);
                startActivity(i);
            }
        });
        todos_los_profesores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Todos_los_profesores.class);
                startActivity(i);
            }
        });
        Log.d("MIO","profes y est");
       todos_los_profesores_y_estudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MIO","fsasdasdin");
                Intent i = new Intent(getApplicationContext(),Todos_los_profesores_y_estudiantes.class);
                startActivity(i);
            }
        });
        Log.d("MIO","volver");
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        Log.d("MIO","fin");
        todos_los_estudiantes_entre_20_y_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),Estudiantes_por_edad.class);
                startActivity(i);
            }
        });
    }

}
