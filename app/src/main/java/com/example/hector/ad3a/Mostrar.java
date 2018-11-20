package com.example.hector.ad3a;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {

    private TextView m_nombre;
    private TextView m_nombreUsuario;
    private TextView m_fNacimiento;
    private TextView m_sexo;
    private Button m_volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);


        m_nombre = (TextView) findViewById(R.id.m_nombre);
        m_nombreUsuario = (TextView) findViewById(R.id.m_nombreUsuario);
        m_fNacimiento = (TextView) findViewById(R.id.m_fNacimiento);
        m_sexo = (TextView) findViewById(R.id.m_sexo);
        m_volver= (Button) findViewById(R.id.m_volver) ;

        SharedPreferences preferencias=getSharedPreferences("Preferencias", Activity.MODE_PRIVATE);

        m_nombre.setText(preferencias.getString("nombre","error"));
        m_nombreUsuario.setText(preferencias.getString("nombreUsuario","error"));
        m_fNacimiento.setText(preferencias.getString("fNacimiento","error"));
        m_sexo.setText(preferencias.getString("sexo","error"));

        m_volver.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
    });
    }


}
