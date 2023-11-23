package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterLibro extends RecyclerView.Adapter<ViewHolderLibro> {

    List<Libro> libros;

    MainActivity activity;

    public AdapterLibro(List<Libro> libros, MainActivity activity) {
        this.libros = libros;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolderLibro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        return new ViewHolderLibro(view, this.activity);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLibro holder, int position) {
        Libro libro = this.libros.get(position);

        holder.tvTitulo.setText(libro.getTitulo());
        holder.tvAutor.setText(libro.getAutor());
    }

    @Override
    public int getItemCount() { return this.libros.size(); }
}
