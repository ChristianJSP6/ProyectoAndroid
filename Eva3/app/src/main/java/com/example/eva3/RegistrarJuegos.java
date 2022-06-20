package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.eva3.Entidades.Usuario;
import com.example.eva3.Utilidades.Utilidades;

public class RegistrarJuegos extends AppCompatActivity {
    CheckBox juego1, juego2, juego3, juego4;
    Button botonSig;
    String game1,game2,game3,game4;
    CnxOpenHelper cnx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_juegos);
        cnx = new CnxOpenHelper(this, "BDUsuarios.db", null, 1);
        isDbEmpty();
        juego1 = findViewById(R.id.cbxJuego1);
        juego2 = findViewById(R.id.cbxJuego2);
        juego3 = findViewById(R.id.cbxJuego3);
        juego4 = findViewById(R.id.cbxJuego4);
        botonSig = findViewById(R.id.btnContinuar);
        botonSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
   private void agregarJuegosBD(){

        try {
            SQLiteDatabase db= cnx.getWritableDatabase();
            ContentValues juegos=new ContentValues();
            game1="League of Legends2";
            game2="Valorant";
            game3="Rocket League";
            game4="Counter Strike";
            String []lista={game1,game2,game3,game4};
           // juegos.put(Utilidades.NOMBRE_JUEGO, game1);
            for (int i = 0; i<lista.length; i++){
                juegos.put(Utilidades.NOMBRE_JUEGO, lista[i]);
                Toast.makeText(this, "ID registrado: " + lista[i], Toast.LENGTH_LONG).show();
                long info = db.insert(Utilidades.TABLA_JUEGOS, Utilidades.ID_CAMPO, juegos);
            }

            Usuario user =new Usuario();

           // Toast.makeText(this, "ID registrado: " + info, Toast.LENGTH_LONG).show();


        }catch (Exception e){
            Toast.makeText(this, "error: " +e, Toast.LENGTH_LONG).show();

        }
    }
    private  boolean isDbEmpty() {
        SQLiteDatabase db= cnx.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_JUEGOS, null);

        if (c.getCount() == 0) {
            Toast.makeText(this,"Vacio",Toast.LENGTH_LONG).show();
            //for empty
            agregarJuegosBD();
            return true;

        }else{
            // not empty
            Toast.makeText(this,"datos bd",Toast.LENGTH_LONG).show();

            return false;

        }
    }
}