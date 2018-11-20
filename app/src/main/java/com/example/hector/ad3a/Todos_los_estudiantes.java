package com.example.hector.ad3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class Todos_los_estudiantes extends AppCompatActivity {


    private MyDBAdapter dbAdapter;
    private Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_los_estudiantes);

        volver=(Button) findViewById(R.id.volver_todos_los_estudiantes);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AD3C.class);
                startActivity(i);
            }
        });
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        TextView res_todos_los_alumnos = (TextView) this.findViewById(R.id.res_todos_los_alumnos);
       // TextView textView2 = (TextView) this.findViewById(R.id.textView2);

        ArrayList<String> alumnos = dbAdapter.recuperarAlumnos();
        res_todos_los_alumnos.setText("");
        //textView2.setText(discos.get(1));
        Log.d("MIO","Fuera");
        for(int cont=0;cont<alumnos.size();cont++){
            Log.d("MIO","Dentro");
            res_todos_los_alumnos.setText(res_todos_los_alumnos.getText()+" "+alumnos.get(cont)+"\n");
            Log.d("MIO","set text");

        }

    }
}
