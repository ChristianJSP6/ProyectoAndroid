package com.example.eva3.Entidades;

public class Usuario {
private String email;
private String nombre;
private String pass;
private String fecha;
private String pre1;
private String res1;
private String pre2;
private String res2;
private String pre3;
private String res3;

    public Usuario() {
    }

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String nombre, String pass, String fecha) {
        this.email = email;
        this.nombre = nombre;
        this.pass = pass;
        this.fecha = fecha;
    }

    public Usuario(String email, String nombre, String pass, String fecha, String pre1, String res1, String pre2, String res2, String pre3, String res3) {
        this.email = email;
        this.nombre = nombre;
        this.pass = pass;
        this.fecha = fecha;
        this.pre1 = pre1;
        this.res1 = res1;
        this.pre2 = pre2;
        this.res2 = res2;
        this.pre3 = pre3;
        this.res3 = res3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPre1() {
        return pre1;
    }

    public void setPre1(String pre1) {
        this.pre1 = pre1;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getPre2() {
        return pre2;
    }

    public void setPre2(String pre2) {
        this.pre2 = pre2;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getPre3() {
        return pre3;
    }

    public void setPre3(String pre3) {
        this.pre3 = pre3;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }
}
