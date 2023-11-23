package com.example.myapplication;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewHolderLibro extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvTitulo;
    TextView tvAutor;
    AdapterLibro adapterLibro;

    public ViewHolderLibro(@NonNull View itemView, AdapterLibro adapterLibro) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.tvTitulo = this.itemView.findViewById(R.id.tvTitulo);
        this.tvAutor = this.itemView.findViewById(R.id.tvAutor);
        this.adapterLibro = adapterLibro;
    }

    @Override
    public void onClick(View view) {

        int position = getAdapterPosition();

        Log.d("Click", "Click " + position);

        if (position != RecyclerView.NO_POSITION) {
            Libro clickedLibro = adapterLibro.getFilteredLibro(position);
            Log.d("Click", "Click " + position + " - " + clickedLibro.toString());

            Intent i = new Intent(view.getContext(), LibroActivity.class);
            i.putExtra("Libro", clickedLibro);

            view.getContext().startActivity(i);
        }
    }
}
