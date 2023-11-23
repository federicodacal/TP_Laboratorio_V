package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterComentario extends RecyclerView.Adapter<ViewHolderComentario> {

    List<Comentario> comentarios;

    public AdapterComentario(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @NonNull
    @Override
    public ViewHolderComentario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comentario, parent, false);
        return new ViewHolderComentario(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderComentario holder, int position) {
        Comentario c = this.comentarios.get(position);
        holder.tvDescripcion.setText(c.getDescripcion());
        holder.tvPuntajeTexto.setText(c.getPuntaje().toString());
        holder.tvTitulo.setText(c.getTituloLibro());
        holder.tvFecha.setText(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(c.getFecha()));
    }

    @Override
    public int getItemCount() {
        return this.comentarios.size();
    }
}
