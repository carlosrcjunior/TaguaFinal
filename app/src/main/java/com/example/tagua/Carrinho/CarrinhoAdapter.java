package com.example.tagua.Carrinho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tagua.R;
import com.example.tagua.preencherCarrinho;

import java.util.List;

public class CarrinhoAdapter extends RecyclerView.Adapter {
    private static final String TAG = "CarrinhoAdapter";
    private List<CarrinhoEntity> carrinhos;
    private Context context;

    public CarrinhoAdapter(List<CarrinhoEntity> carrinhos,Context context){
        this.carrinhos = carrinhos;
        this.context = context;
    }

    @NonNull
    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_carrinho,parent,false);
        return new CarrinhoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        CarrinhoViewHolder carrinhoViewHolder = (CarrinhoViewHolder) holder;
        CarrinhoEntity carrinho = carrinhos.get(position);
        carrinhoViewHolder.getIdCarrinho.setText(Integer.toString(carrinho.getId()));
        carrinhoViewHolder.getDescricao.setText(carrinho.getDescricao());
        carrinhoViewHolder.getValor.setText("R$ "+ Integer.toString(carrinho.getValor()));
        carrinhoViewHolder.removeButton.setOnClickListener(view -> remover(position));
    }

    @Override
    public int getItemCount(){ return carrinhos != null ? carrinhos.size() :0; }

    public void remover(int position){
        CarrinhoEntity carrinho = carrinhos.get(position);
        System.out.println(carrinho);
        int id,valor;
        String descricao;
        id = carrinho.getId();
        valor = carrinho.getValor();
        descricao = carrinho.getDescricao();
        preencherCarrinho preencherCarrinho = new preencherCarrinho(id,valor,descricao,context);
        preencherCarrinho.remover();


        carrinhos.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,carrinhos.size());
    }
}
