package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.io.Serializable;

public class LibroActivity extends AppCompatActivity {

    public static Libro libroSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);

        Bundle bundle = super.getIntent().getExtras();
        Serializable ser = bundle.getSerializable("Libro");
        libroSeleccionado = (Libro) ser;
        Log.d("LibroActivity", libroSeleccionado.toString());

        ActionBar ab = super.getSupportActionBar();
        ab.setTitle(libroSeleccionado.getTitulo());
        ab.setDisplayHomeAsUpEnabled(true);

        Libro model = new Libro();
        LibroView view = new LibroView(this, model);
        LibroController controller = new LibroController(view, model, this);
        view.setController(controller);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}