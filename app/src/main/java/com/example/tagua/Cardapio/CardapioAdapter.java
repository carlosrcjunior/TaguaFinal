package com.example.tagua.Cardapio;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tagua.Carrinho.AppDataBaseCarrinho;
import com.example.tagua.Carrinho.CarrinhoAdapter;
import com.example.tagua.Carrinho.CarrinhoDao;
import com.example.tagua.Carrinho.CarrinhoEntity;
import com.example.tagua.MainActivity;
import com.example.tagua.R;
import com.example.tagua.preencherCarrinho;

import java.util.ArrayList;
import java.util.List;

public class CardapioAdapter extends RecyclerView.Adapter {
    private static final String TAG = "CardapioAdapter";
    private List<CardapioEntity> cardapios;
    private Context context;


    public CardapioAdapter(List<CardapioEntity> cardapios, Context context) {
        this.cardapios = cardapios;
        this.context = context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_cardapio,parent, false);
        return new CardapioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Log.d(TAG,"position:" + position);
        CardapioViewHolder cardapioHolder = (CardapioViewHolder) holder;
        CardapioEntity cardapio = cardapios.get(position);
        cardapioHolder.getIdcardapio.setText(Integer.toString(cardapio.getId()));
        cardapioHolder.getDescricao.setText(cardapio.getDescricao());
        cardapioHolder.getValor.setText("R$ "+ Integer.toString(cardapio.getValor()));
        cardapioHolder.addButton.setOnClickListener(view -> adicionar(position));
    }

    @Override
    public int getItemCount() { return cardapios.size();   }

    public void adicionar(int position){
        CardapioEntity cardapio = cardapios.get(position);
        //System.out.println(cardapio);
        int id,valor;
        String descricao;
        id = cardapio.getId();
        valor = cardapio.getValor();
        descricao = cardapio.getDescricao();
        preencherCarrinho preencherCarrinho = new preencherCarrinho(id,valor,descricao,context);
        preencherCarrinho.adicionar();
    }
}