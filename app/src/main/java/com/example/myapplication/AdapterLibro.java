package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterLibro extends RecyclerView.Adapter<ViewHolderLibro> implements Filterable {

    List<Libro> libros;
    List<Libro> filteredLibros;

    MainActivity activity;

    public AdapterLibro(List<Libro> libros, MainActivity activity) {
        this.libros = libros;
        this.activity = activity;
        this.filteredLibros = new ArrayList<>(libros);
    }

    @NonNull
    @Override
    public ViewHolderLibro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        return new ViewHolderLibro(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLibro holder, int position) {
            Libro libro = this.filteredLibros.get(position);

            holder.tvTitulo.setText(libro.getTitulo());
            holder.tvAutor.setText(libro.getAutor());
    }


    @Override
    public int getItemCount() {
        return this.filteredLibros.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String filterPattern = constraint.toString().toLowerCase().trim();

                List<Libro> filteredList = new ArrayList<>();
                for (Libro libro : libros) {
                    if (libro.getTitulo().toLowerCase().contains(filterPattern)) {
                        filteredList.add(libro);
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;
                results.count = filteredList.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredLibros.clear();
                filteredLibros.addAll((List<Libro>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public Libro getFilteredLibro(int position) {
        return filteredLibros.get(position);
    }

}


