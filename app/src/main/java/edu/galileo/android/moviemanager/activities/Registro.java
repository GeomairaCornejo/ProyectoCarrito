package edu.galileo.android.moviemanager.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.Main2Activity;
import edu.galileo.android.moviemanager.entidades.DBHelper;

public class Registro extends AppCompatActivity {
    Button bt1;
    EditText txtNombre, txtEmail, txtContraseña;
    DBHelper helper = new DBHelper(this, "DB1", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        bt1 = (Button) findViewById(R.id.btn1);
        txtNombre = (EditText) findViewById(R.id.nombre);
        txtEmail = (EditText) findViewById(R.id.email);
        txtContraseña = (EditText) findViewById(R.id.contraseña);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.abrir();
                helper.insertarRegistro(String.valueOf(txtNombre.getText()),
                        String.valueOf(txtEmail.getText()),
                        String.valueOf(txtContraseña.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(), "SE HA REGISTRADO CON EXITO..!!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
