package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class LibroController implements View.OnClickListener {

    private Libro model;
    private LibroView view;
    private Activity activity;

    public LibroController(LibroView view, Libro model, Activity activity) {
        this.model = model;
        this.view = view;
        this.activity = activity;
        this.view.setController(this);
    }

    public void guardarComentario() {
        this.view.cargarModelo();
        if (this.validarDatos()) {
            Comentario comentario = new Comentario();
            comentario.setPuntaje(this.view.getPuntaje());
            comentario.setDescripcion(this.view.getComentario());
            comentario.setTituloLibro(this.model.getTitulo());  // Use libro title or adjust as needed
            comentario.setFecha(new Date());

            this.model.setComentario(comentario);

            Log.d("Comentario", this.model.getComentario().toString());

            // Save data to SharedPreferences or perform any other necessary tasks
            this.saveDataToSharedPreferences();

            this.activity.finish();
        }
    }

    private boolean validarDatos() {
        if((Float)this.view.getPuntaje() == null || this.view.getPuntaje() == 0) {
            Toast toast = Toast.makeText(this.activity, "Error. Debe llenar el puntaje!", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        else if(this.view.getComentario() == null || this.view.getComentario().trim().isEmpty()) {
            Toast toast = Toast.makeText(this.activity, "Error. Debe dejar un comentario!", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        else {
            return true;
        }
    }

    private void saveDataToSharedPreferences() {
        // Load existing data from SharedPreferences
        List<Comentario> comentarioList = loadDataFromSharedPreferences();

        // Add the new comentario to the list
        comentarioList.add(this.model.getComentario());

        // Serialize the list to JSON
        Gson gson = new Gson();
        String json = gson.toJson(comentarioList);

        // Save the JSON string to SharedPreferences
        SharedPreferences sharedPreferences = activity.getSharedPreferences("LibroPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("arrayComentarios", json);
        editor.apply();

        Log.d("Comentario JSON", json);
    }

    private List<Comentario> loadDataFromSharedPreferences() {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("LibroPreferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("arrayComentarios", "[]");

        // Deserialize the JSON string to a list of Comentario objects
        Type type = new TypeToken<List<Comentario>>() {}.getType();
        return gson.fromJson(json, type);
    }


    @Override
    public void onClick(View v) {
        this.guardarComentario();
    }
}
