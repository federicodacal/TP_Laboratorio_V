package com.example.myapplication;

import java.io.Serializable;
import java.util.Date;

public class Comentario implements Serializable {

    private String tituloLibro;
    private String descripcion;
    private Float puntaje;
    private Date fecha;

    public Comentario() { }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String comentario) {
        this.descripcion = comentario;
    }

    public Float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Float puntaje) {
        this.puntaje = puntaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "tituloLibro='" + tituloLibro + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", puntaje=" + puntaje +
                ", fecha=" + fecha +
                '}';
    }
}
