package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.io.Serializable;

public class LibroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);

        Bundle bundle = super.getIntent().getExtras();
        Serializable ser = bundle.getSerializable("Libro");
        Libro libro = (Libro) ser;
        Log.d("LibroActivity", libro.toString());

        ActionBar ab = super.getSupportActionBar();
        ab.setTitle(libro.getTitulo());
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}