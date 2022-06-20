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

public class RecuperarPass extends AppCompatActivity {
    EditText correo;
    Button continuar;
    CnxOpenHelper cnx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_pass);
        cnx = new CnxOpenHelper(this,"BDUsuarios.db",null,1);
        correo=findViewById(R.id.etMail);
        continuar=findViewById(R.id.btnContinuar2);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });

    }
    private void consultar(){
        String[]id= {correo.getText().toString()};
    SQLiteDatabase db=cnx.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM Usuarios WHERE email=?",id);
        if (cursor.moveToFirst()){
            Intent i= new Intent(RecuperarPass.this, PreguntasRecuperarPAss.class);
            i.putExtra("recuperar",correo.getText().toString());
            startActivity(i);
        }else{
            Toast.makeText(this, "No existe un registro con ese nombre", Toast.LENGTH_LONG).show();

        }
    }
}
