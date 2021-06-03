package com.example.whattoeat.models;

public class enviarPost {
    private String nombre;
    private int id;
    private boolean b;

    public enviarPost(String nombre, int id, boolean b) {
        this.nombre = nombre;
        this.id = id;
        this.b = b;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}