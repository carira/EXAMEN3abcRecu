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

public class MainActivity extends AppCompatActivity {

    private Button registrar;
    private Button mostrar;
    private Button boton_3b;
    private Button boton_3c;
    private Button b_asignaturas;
    private EditText nombre;
    private EditText nombreUsuario;
    private EditText fNacimiento;
    private RadioGroup sexo;
    private RadioButton sexoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    registrar=(Button) findViewById(R.id.registrar);
    mostrar=(Button) findViewById(R.id.mostrar);
    boton_3b=(Button) findViewById(R.id.AD3b);
    boton_3c=(Button) findViewById(R.id.AD3c);
    b_asignaturas=(Button) findViewById(R.id.b_asignaturas) ;
    nombre=(EditText) findViewById(R.id.nombre);
    nombreUsuario=(EditText) findViewById(R.id.nombreUsuario);
    fNacimiento=(EditText) findViewById(R.id.fNacimiento);
    sexo=(RadioGroup) findViewById(R.id.sexo);
    sexoB=(RadioButton) findViewById(R.id.sexoB);
    registrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences preferencias=getSharedPreferences("Preferencias", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferencias.edit();

            editor.putString("nombre", nombre.getText().toString());
            editor.putString("nombreUsuario", nombreUsuario.getText().toString());
            editor.putString("fNacimiento", fNacimiento.getText().toString());
            if(sexo.getCheckedRadioButtonId()!=-1){
                if (sexoB.isChecked()){
                    editor.putString("sexo", "Hombre");
                }
                else{
                    editor.putString("sexo", "Mujer");
                }

            }
            else{
                editor.putString("sexo", "Otro");
            }
            editor.commit();
            nombre.setText("");
            nombreUsuario.setText("");
            fNacimiento.setText("");
            sexo.clearCheck();
        }
    });
    mostrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i =new Intent(getApplicationContext(),Mostrar.class);
            startActivity(i);

        }
    });
    boton_3b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent (getApplicationContext(),AD3B.class);
            startActivity(i);
        }
    });

    boton_3c.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(getApplicationContext(),AD3C.class);
            startActivity(i);
        }
    });
    b_asignaturas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(),Asignaturas.class);
            startActivity(i);
        }
    });
    }

}
