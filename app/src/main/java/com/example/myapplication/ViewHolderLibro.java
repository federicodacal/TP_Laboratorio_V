package com.example.myapplication;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderLibro extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvTitulo;
    TextView tvAutor;

    MainActivity mainActivity;

    public ViewHolderLibro(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.tvTitulo = this.itemView.findViewById(R.id.tvTitulo);
        this.tvAutor = this.itemView.findViewById(R.id.tvAutor);
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {

        int position = super.getAbsoluteAdapterPosition();

        Log.d("Click", "Click " + position);

        Intent i = new Intent(view.getContext(), LibroActivity.class);

        if(position != RecyclerView.NO_POSITION) {

            Log.d("Libro", mainActivity.libros.get(position).toString());

            i.putExtra("Libro", mainActivity.libros.get(position));

            view.getContext().startActivity(i);
        }
    }
}
