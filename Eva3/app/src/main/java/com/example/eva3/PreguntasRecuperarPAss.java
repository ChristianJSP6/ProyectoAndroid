package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eva3.Utilidades.Utilidades;

public class PreguntasRecuperarPAss extends AppCompatActivity {
EditText resp1,resp2,resp3;
Button botonNext;
    CnxOpenHelper cnx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cnx = new CnxOpenHelper(this,"BDUsuarios.db",null,1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_recuperar_pass);
        resp1=findViewById(R.id.etResp1);
        resp2=findViewById(R.id.etResp2);
        resp3=findViewById(R.id.etResp3);
        botonNext=findViewById(R.id.btnNext);
        botonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarRespuestas();
            }
        });
    }

   private void validarRespuestas(){
       Bundle info=getIntent().getExtras();
       SQLiteDatabase db=cnx.getReadableDatabase();
       String email= info.getString("recuperar");
       String[]id={email};
       Cursor cursor=db.rawQuery("SELECT res1, res2,res3 FROM Usuarios WHERE email=?",id);
       cursor.moveToFirst();
       String respuesta1=cursor.getString(0);
       String respuesta2=cursor.getString(1);
       String respuesta3=cursor.getString(2);
       if (respuesta1.equalsIgnoreCase(resp1.getText().toString()) && respuesta2.equalsIgnoreCase(resp2.getText().toString()) && respuesta3.equalsIgnoreCase(resp3.getText().toString())){
           Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show();
           Intent i= new Intent(PreguntasRecuperarPAss.this, Password.class);
           i.putExtra("correo",email);
           startActivity(i);
       }else{
           Toast.makeText(this, "Lo Lamento Tus Respuestas No Son Correctas", Toast.LENGTH_LONG).show();
       }
   }
}