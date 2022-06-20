package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Password extends AppCompatActivity {
EditText pass;
Button btnInicio;
    CnxOpenHelper cnx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        cnx = new CnxOpenHelper(this,"BDUsuarios.db",null,1);
        pass=findViewById(R.id.etRecuperar);
        btnInicio=findViewById(R.id.btnInicio);
        mostrarPass();
        btnInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }
    private void mostrarPass(){
        Bundle info=getIntent().getExtras();
        SQLiteDatabase db=cnx.getReadableDatabase();
        String email= info.getString("correo");
        String[]id={email};
        Cursor cursor=db.rawQuery("SELECT pass FROM Usuarios WHERE email=?",id);
        cursor.moveToFirst();
        pass.setText(cursor.getString(0));
        pass.setKeyListener(null);
    }
}