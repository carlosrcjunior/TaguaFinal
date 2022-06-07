package com.example.tagua.Cardapio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tagua.R;

import java.util.List;

public class CardapioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cardapios);

        //inicio
        RecyclerView recyclerView = findViewById(R.id.recycler);
        AppDataBaseCardapio db = AppDataBaseCardapio.getInstance(this);
        CardapioDao dao = db.cardapioDao();
        List<CardapioEntity> cardapio = dao.getCardapio();
        //System.out.println(dao.getCardapio());
        recyclerView.setAdapter( new CardapioAdapter(cardapio,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);
    }
}