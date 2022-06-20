package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button registrar, ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrar=findViewById(R.id.btnRegistrar);
        ingresar=findViewById(R.id.btnIngresar);
        CnxOpenHelper Cnx= new CnxOpenHelper(this,"BDUsuarios.db",null,1);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this, Registrar.class);
                startActivity(i);
            }
        });
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, RecuperarPass.class);
                startActivity(i);
            }
        });
    }
}