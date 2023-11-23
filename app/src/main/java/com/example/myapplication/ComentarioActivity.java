package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ComentarioActivity extends AppCompatActivity {

    List<Comentario> listComentarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);

        this.listComentarios = this.loadDataFromSharedPreferences();

        AdapterComentario adapterComentario = new AdapterComentario(listComentarios);
        RecyclerView rv = findViewById(R.id.rvComentario);
        rv.setAdapter(adapterComentario);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
    }

    private List<Comentario> loadDataFromSharedPreferences() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("LibroPreferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("arrayComentarios", "[]");

        // Deserialize the JSON string to a list of Comentario objects
        Type type = new TypeToken<List<Comentario>>() {}.getType();
        return gson.fromJson(json, type);
    }

}