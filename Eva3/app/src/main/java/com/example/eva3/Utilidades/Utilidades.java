package com.example.eva3.Utilidades;

public class Utilidades {
    public static final String TABLA_USUARIO="Usuarios";
    public static final String CAMPO_ID="email";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_PASS="pass";
    public static final String CAMPO_FECHA="fecha";
    public static final String CAMPO_PRE1="pre1";
    public static final String CAMPO_PRE2="pre2";
    public static final String CAMPO_PRE3="pre3";
    public static final String CAMPO_RES1="res1";
    public static final String CAMPO_RES2="res2";
    public static final String CAMPO_RES3="res3";
    public static final String CREAR_TABLA_USUARIOS="create table "+ TABLA_USUARIO+" " +
            "("+CAMPO_ID+" TEXT primary key,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_PASS+" TEXT, "+CAMPO_FECHA+" TEXT, "+
            CAMPO_PRE1+" TEXT, "+CAMPO_RES1+ " TEXT, "+ CAMPO_PRE2 + " TEXT, "+ CAMPO_RES2+" TEXT, "+ CAMPO_PRE3+
            " TEXT, "+ CAMPO_RES3 +" TEXT)";
   /*public static final String TABLA_USUARIO="Usuarios";
    public static final String CAMPO_ID="email";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_PASS="pass";
    public static final String CAMPO_FECHA="fecha";
    public static final String CREAR_TABLA_USUARIOS="create table "+ TABLA_USUARIO+" " +
            "("+CAMPO_ID+" INTEGER primary key,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_PASS+" TEXT, "+CAMPO_FECHA+" TEXT)";*/


    public static final String TABLA_JUEGOS="Juegos";
    public static final String ID_CAMPO="idJuego";
    public static final String NOMBRE_JUEGO="nombreJuego";
    public static final String CREAR_TABLA_JUEGOS="create table "+ TABLA_JUEGOS+ "( "+ID_CAMPO+" INTEGER primary key AUTOINCREMENT, "+ NOMBRE_JUEGO +" TEXT )";

}
