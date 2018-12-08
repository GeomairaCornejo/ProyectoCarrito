package edu.galileo.android.moviemanager.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.entidades.DBHelper;

public class Registro extends AppCompatActivity {
    EditText edi1,edi2, edi3, edi4;
    Button btn1;
    DBHelper db;
    CardView registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        db = new DBHelper(this);
        edi1= (EditText)findViewById(R.id.edi1);
        edi2= (EditText)findViewById(R.id.edi2);
        edi3= (EditText)findViewById(R.id.edi3);
        edi4= (EditText)findViewById(R.id.edi4);
        btn1= (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = edi1.getText().toString();
                String s2 = edi2.getText().toString();
                String s3 = edi3.getText().toString();
                String s4 = edi4.getText().toString();
                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"Los campos estan vacios", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (s2.equals(s3)||s4.equals(s2)) {
                        boolean Chkusuario = db.Chkuser(s1);
                        if (Chkusuario == true) {
                            boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Resgistrado correctamente", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuario existe", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });
    }
}
