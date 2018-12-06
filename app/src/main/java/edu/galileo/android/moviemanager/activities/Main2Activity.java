package edu.galileo.android.moviemanager.activities;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.Registro;

public class Main2Activity extends AppCompatActivity {
    CardView registrarse;
 CardView ir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ir = (CardView) findViewById(R.id.view);
        registrarse = (CardView) findViewById(R.id.view1);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarse = new Intent(Main2Activity.this, Registro.class);
                startActivity(registrarse);
            }
        });

        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(ir);
            }
        });
    }

}
