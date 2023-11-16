package com.example.myapplication;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderLibro extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvTitulo;
    TextView tvAutor;

    public ViewHolderLibro(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.tvTitulo = this.itemView.findViewById(R.id.tvTitulo);
        this.tvAutor = this.itemView.findViewById(R.id.tvAutor);
    }

    @Override
    public void onClick(View view) {
        Log.d("Click", "Click " + super.getAdapterPosition());
    }
}
