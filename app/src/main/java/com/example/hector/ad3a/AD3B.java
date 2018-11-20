package com.example.hector.ad3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AD3B extends AppCompatActivity {

    private Button b_alumno;
    private Button b_profesor;
    private Button b_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad3_b);


        b_alumno=(Button) findViewById(R.id.button_alumno);
        b_profesor=(Button)findViewById(R.id.button_profesor);
        b_volver=(Button) findViewById(R.id.ad3b_volver);

        b_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),RegistroAlumnos.class);
                startActivity(i);
            }
        });
        b_profesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),RegistroProfesores.class);
                startActivity(i);
            }
        });
        b_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
