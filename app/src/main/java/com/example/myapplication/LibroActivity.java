package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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
    }
}