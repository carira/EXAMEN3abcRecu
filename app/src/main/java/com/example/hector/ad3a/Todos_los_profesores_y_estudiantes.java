package com.example.hector.ad3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class Todos_los_profesores_y_estudiantes extends AppCompatActivity {

    private TextView res_todo_alumno;
    private TextView res_todo_profesor;
    private MyDBAdapter dbAdapter;
    private Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_los_profesores_y_estudiantes);
        volver=(Button) findViewById(R.id.volver_todos_los_profesores_y_estudiantes);
        res_todo_alumno=(TextView)findViewById(R.id.todo_alumno);
        res_todo_profesor=(TextView) findViewById(R.id.todo_profesor);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AD3C.class);
                startActivity(i);
            }
        });
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        ArrayList<String> alumnos = dbAdapter.recuperarAlumnos();
        res_todo_alumno.setText("");
        //textView2.setText(discos.get(1));
        Log.d("MIO","Fuera");
        for(int cont=0;cont<alumnos.size();cont++){
            Log.d("MIO","Dentro");
            res_todo_alumno.setText(res_todo_alumno.getText()+" "+alumnos.get(cont)+"\n");
            Log.d("MIO","set text");

        }

        ArrayList<String> profesores = dbAdapter.recuperarProfesores();
        res_todo_profesor.setText("");
        //textView2.setText(discos.get(1));
        Log.d("MIO","Fuera");
        for(int cont=0;cont<profesores.size();cont++){
            Log.d("MIO","Dentro");
            res_todo_profesor.setText(res_todo_profesor.getText()+" "+profesores.get(cont)+"\n");
            Log.d("MIO","set text");

        }

    }
}
