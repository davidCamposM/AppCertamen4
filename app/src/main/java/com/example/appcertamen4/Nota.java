package com.example.appcertamen4;

public class Nota {
    private String titulo;
    private String contenido;

    public Nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    //Getters
    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }
}
