package com.example.myapplication;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class LibroView {
    Activity activity;
    Libro model;
    LibroController controller;
    Button btn;
    TextView tvAutor;
    ImageView ivLibro;
    EditText edComentario;
    RatingBar rbar;

    public LibroView(Activity activity, Libro model) {
        this.activity = activity;
        this.model = model;
        this.btn = activity.findViewById(R.id.btnGuardar);
        this.controller = new LibroController(this, model, this.activity);
        this.edComentario = activity.findViewById(R.id.edComentario);
        this.rbar = activity.findViewById(R.id.rating);
        this.tvAutor = activity.findViewById(R.id.tvAutor);
        this.ivLibro = activity.findViewById(R.id.ivLibro);
        this.cargarModelo();
    }

    public void setController(LibroController controller) {
        this.controller = controller;
        this.btn.setOnClickListener(this.controller);
    }

    public void cargarModelo() {
        this.model.setTitulo(LibroActivity.libroSeleccionado.getTitulo());
        this.model.setId(LibroActivity.libroSeleccionado.getId());
        this.model.setAutor(LibroActivity.libroSeleccionado.getAutor());
        this.model.setUrlImg(LibroActivity.libroSeleccionado.getUrlImg());

        Comentario comentario = LibroActivity.libroSeleccionado.getComentario();
        if (comentario != null) {
            this.setPuntaje(comentario.getPuntaje());
            this.setComentario(comentario.getDescripcion());
        }

        this.mostrarModelo();
    }

    public void setPuntaje(float puntaje) {
        rbar.setRating(puntaje);
    }

    public float getPuntaje() {
        return rbar.getRating();
    }

    public void setComentario(String comentario) {
        edComentario.setText(comentario);
    }

    public String getComentario() {
        return edComentario.getText().toString();
    }

    public void mostrarModelo() {
        this.tvAutor.setText(this.model.getAutor());
        Picasso.get().load(this.model.getUrlImg()).into(this.ivLibro);
    }

}
