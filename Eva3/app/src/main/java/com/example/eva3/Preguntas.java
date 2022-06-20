package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eva3.Utilidades.Utilidades;

public class Preguntas extends AppCompatActivity {
TextView resp1, resp2, resp3;
Button siguiente;
    CnxOpenHelper cnx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        resp1=findViewById(R.id.etRes1);
        resp2=findViewById(R.id.etRes2);
        resp3=findViewById(R.id.etRes3);
        siguiente=findViewById(R.id.btnSig);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Actualizar();
            }
        });

    }

    private void Actualizar(){

        try {
            cnx = new CnxOpenHelper(this,"BDUsuarios.db",null,1);
            Bundle info=getIntent().getExtras();
            String email= info.getString("datoEmail");
            SQLiteDatabase db=cnx.getWritableDatabase();
            String[] parametros={email};
            ContentValues registro= new ContentValues();
            registro.put(Utilidades.CAMPO_RES1,resp1.getText().toString());
            registro.put(Utilidades.CAMPO_RES2,resp2.getText().toString());
            registro.put(Utilidades.CAMPO_RES3,resp3.getText().toString());
            db.update(Utilidades.TABLA_USUARIO,registro,Utilidades.CAMPO_ID+"=?",parametros);
            Toast.makeText(this,"Respuestas Guardadas", Toast.LENGTH_LONG).show();
            db.close();
            Intent i2= new Intent(Preguntas.this, RegistrarJuegos.class);
            startActivity(i2);
        }catch (Exception e){
            Toast.makeText(this,"Error"+ e, Toast.LENGTH_LONG).show();
        }

    }
}