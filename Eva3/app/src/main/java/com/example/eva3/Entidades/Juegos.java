package com.example.eva3.Entidades;

public class Juegos {
    private int id;
    private String nombreJuego;

    public Juegos() {
    }

    public Juegos(int id, String nombreJuego) {
        this.id = id;
        this.nombreJuego = nombreJuego;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }
}
