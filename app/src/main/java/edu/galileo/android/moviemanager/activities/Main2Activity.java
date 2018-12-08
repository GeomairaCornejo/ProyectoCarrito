package edu.galileo.android.moviemanager.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.entidades.DBHelper;
import edu.galileo.android.moviemanager.models.Registro;

public class Main2Activity extends AppCompatActivity {
    CardView registrarse;
    CardView ir;
    EditText editext, ediText2;
    DBHelper dbHelper;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHelper = new DBHelper(this);
        editext = (EditText) findViewById(R.id.editext);
        ediText2 = (EditText) findViewById(R.id.editText2);
        registrarse = (CardView) findViewById(R.id.view1);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarse = new Intent(Main2Activity.this, Registro.class);
                startActivity(registrarse);
            }
        });
        ir = (CardView) findViewById(R.id.view);
        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editext.getText().toString();
                String contrasena = ediText2.getText().toString();
                Boolean Chkusuariocontr = dbHelper.usercontrasena(usuario,contrasena);
                Intent ir = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(ir);
                if (Chkusuariocontr== true)
                    Toast.makeText(getApplicationContext()," usuario o contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Login Exitoso!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
