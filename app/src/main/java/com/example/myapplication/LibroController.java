package com.example.myapplication;

import android.view.View;

public class LibroController implements View.OnClickListener {

    Libro model;
    LibroView view;

    public LibroController(LibroView view, Libro model) {
        this.model = model;
        this.view = view;
    }

    public void guardarComentario() {
        this.view.cargarModelo();
        if(this.validarDatos()) {
            //
        }
    }

    private boolean validarDatos() {
        return true;
    }

    @Override
    public void onClick(View v) {
        this.view.activity.finish();
    }
}
