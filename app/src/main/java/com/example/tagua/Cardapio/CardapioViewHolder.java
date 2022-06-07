package com.example.tagua.Cardapio;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tagua.R;

public class CardapioViewHolder extends RecyclerView.ViewHolder {
    final TextView getIdcardapio;
    final TextView getValor;
    final TextView getDescricao;
    final ImageButton addButton;
        public CardapioViewHolder(@NonNull View itemView) {
            super(itemView);
            getIdcardapio = itemView.findViewById(R.id.item_cardapio_id);
            getValor = itemView.findViewById(R.id.item_cardapio_valor);
            getDescricao = itemView.findViewById(R.id.item_cardapio_descricao);
            addButton = itemView.findViewById(R.id.addButton);
    }


}
