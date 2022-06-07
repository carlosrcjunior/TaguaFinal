package com.example.tagua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tagua.Cardapio.AppDataBaseCardapio;
import com.example.tagua.Cardapio.CardapioActivity;
import com.example.tagua.Cardapio.CardapioDao;
import com.example.tagua.Cardapio.CardapioEntity;
import com.example.tagua.Carrinho.AppDataBaseCarrinho;
import com.example.tagua.Carrinho.CarrinhoActivity;
import com.example.tagua.Carrinho.CarrinhoDao;
import com.example.tagua.Carrinho.CarrinhoEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preencherCardapio();


        AppDataBaseCarrinho dbCarrinho = AppDataBaseCarrinho.getInstance(getApplicationContext());
        CarrinhoDao carrinhoDao = dbCarrinho.carrinhoDao();
        carrinhoDao.zeraCarrinho();
    }

    public void botaoCardapio(View view){

        Intent intent = new Intent(this, CardapioActivity.class);
        startActivity(intent);
    }

    public void botaoCarrinho(View view){

        Intent intent = new Intent(this, CarrinhoActivity.class);
        startActivity(intent);
    }

    public void preencherCardapio(){
        AppDataBaseCardapio dbCardapio = AppDataBaseCardapio.getInstance(getApplicationContext());
        CardapioDao cardapioDao = dbCardapio.cardapioDao();
        CardapioEntity cardapio = new CardapioEntity(1,200, "Bebida 1");
        List<CardapioEntity> listaCardapio = new ArrayList<>();
        listaCardapio.add(cardapio);
        cardapioDao.insertAll(listaCardapio);
        cardapio = new CardapioEntity(2,200, "Bebida 2");
        listaCardapio.add(cardapio);
        cardapioDao.insertAll(listaCardapio);
        cardapio = new CardapioEntity(3,200, "Bebida 3");
        listaCardapio.add(cardapio);
        cardapioDao.insertAll(listaCardapio);
        cardapio = new CardapioEntity(4,200, "Bebida 4");
        listaCardapio.add(cardapio);
        cardapioDao.insertAll(listaCardapio);
        cardapio = new CardapioEntity(5,200, "Bebida 5");
        listaCardapio.add(cardapio);
        cardapioDao.insertAll(listaCardapio);
        cardapio = new CardapioEntity(6,200, "Bebida 6");
        listaCardapio.add(cardapio);
        cardapioDao.insertAll(listaCardapio);
    }
}