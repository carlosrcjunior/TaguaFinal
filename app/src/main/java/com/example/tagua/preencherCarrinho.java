package com.example.tagua;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tagua.Cardapio.CardapioEntity;
import com.example.tagua.Carrinho.AppDataBaseCarrinho;
import com.example.tagua.Carrinho.CarrinhoDao;
import com.example.tagua.Carrinho.CarrinhoEntity;

import java.util.ArrayList;
import java.util.List;

public class preencherCarrinho {
    int id;
    int valor;
    String Desc;
    Context context;

    public preencherCarrinho(int id, int valor, String Desc,Context context){
        this.id = id;
        this.valor = valor;
        this.Desc = Desc;
        this.context = context;
    }

    public void adicionar(){
        AppDataBaseCarrinho dbCarrinho = AppDataBaseCarrinho.getInstance(context);
        CarrinhoDao carrinhoDao = dbCarrinho.carrinhoDao();
        CarrinhoEntity carrinho = new CarrinhoEntity(id,valor,Desc);
        List<CarrinhoEntity> listaCarrinho = new ArrayList<>();
        listaCarrinho.add(carrinho);
        //System.out.println("listaCarrinho "+listaCarrinho.size());
        carrinhoDao.insertAll(listaCarrinho);
    }

    public void remover(){
        AppDataBaseCarrinho dbCarrinho = AppDataBaseCarrinho.getInstance(context);
        CarrinhoDao carrinhoDao = dbCarrinho.carrinhoDao();
        carrinhoDao.deletaItem(id);
    }
}
