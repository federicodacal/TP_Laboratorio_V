package com.example.myapplication;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderComentario extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvDescripcion;
    TextView tvPuntajeTexto;
    TextView tvTitulo;
    TextView tvFecha;

    public ViewHolderComentario(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.tvTitulo = this.itemView.findViewById(R.id.tvTituloTxt);
        this.tvDescripcion = this.itemView.findViewById(R.id.tvDescripcion);
        this.tvPuntajeTexto = this.itemView.findViewById(R.id.tvPuntajeTxt);
        this.tvFecha = this.itemView.findViewById(R.id.tvFecha);
    }

    @Override
    public void onClick(View v) {
        Log.d("Click", "Click " + super.getAbsoluteAdapterPosition());
    }
}
