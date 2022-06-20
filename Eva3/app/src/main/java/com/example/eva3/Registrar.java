package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eva3.Utilidades.Utilidades;

public class Registrar extends AppCompatActivity {
EditText correo,nick,pass,fecha;
Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        correo=findViewById(R.id.etCorreo);
        nick=findViewById(R.id.etNombre);
        pass=findViewById(R.id.etContra);
        fecha=findViewById(R.id.etFecha);
        registrar=findViewById(R.id.btnRegistro);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario(){
        CnxOpenHelper cnx=new CnxOpenHelper(this,"BDUsuarios.db",null,1);
        SQLiteDatabase db= cnx.getWritableDatabase();
        ContentValues agregar=new ContentValues();
        try{
            if (correo.getText().toString().isEmpty()|| nick.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || fecha.getText().toString().isEmpty()){
                Toast.makeText(this,"Error: Campos Vacíos",Toast.LENGTH_LONG).show();
            }else{
            agregar.put(Utilidades.CAMPO_ID,correo.getText().toString());
            agregar.put(Utilidades.CAMPO_NOMBRE,nick.getText().toString());
            agregar.put(Utilidades.CAMPO_PASS,pass.getText().toString());
            agregar.put(Utilidades.CAMPO_FECHA,fecha.getText().toString());
            long info=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,agregar);

                if (info!=-1){
                    Toast.makeText(this,"ID registrado: " + info,Toast.LENGTH_LONG).show();
                    db.close();
                    Intent intent=new Intent(Registrar.this,Preguntas.class);
                    intent.putExtra("datoEmail",correo.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"Error: Usuario ya Existe",Toast.LENGTH_LONG).show();
                }
            }
        }catch (Exception e){
            Toast.makeText(this,"error: " + e,Toast.LENGTH_LONG).show();
        }


    }
}