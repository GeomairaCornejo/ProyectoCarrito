package edu.galileo.android.moviemanager.activities;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.entidades.DBHelper;

public class Main2Activity extends AppCompatActivity {
    CardView registrarse;
    CardView ir;

    DBHelper helper = new DBHelper(this,"DB1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
                EditText txtusu=(EditText)findViewById(R.id.ediUsuario);
                EditText txtPass = (EditText)findViewById(R.id.ediPassword);
                try {
                    Cursor cursor = helper.ConsultarUsuPas(txtusu.getText().
                            toString(),txtPass.getText().toString());
                    if(cursor.getCount()>0){
                        Intent ir = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(ir);
                    }else{
                        Toast.makeText(getApplicationContext(),"USUARIO Y/O PASSWORD INCORRECTA.",
                                Toast.LENGTH_LONG).show();
                    }
                    txtusu.setText("");
                    txtPass.setText("");
                    txtusu.findFocus();
                }catch (SQLException e){
                    e.printStackTrace();
                }


            }
        });

    }

}
