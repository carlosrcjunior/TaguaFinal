package com.example.tagua.Carrinho;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tagua.R;

public class CarrinhoViewHolder extends RecyclerView.ViewHolder {
    final TextView getIdCarrinho;
    final TextView getValor;
    final TextView getDescricao;
    final ImageButton removeButton;
    public CarrinhoViewHolder(@NonNull View itemView2) {
        super(itemView2);
        getIdCarrinho = itemView2.findViewById(R.id.item_carrinho_id);
        getValor = itemView2.findViewById(R.id.item_carrinho_valor);
        getDescricao = itemView2.findViewById(R.id.item_carrinho_descricao);
        removeButton = itemView2.findViewById(R.id.removeButton);
    }
}
