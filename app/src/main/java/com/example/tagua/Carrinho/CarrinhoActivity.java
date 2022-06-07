package com.example.tagua.Carrinho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tagua.R;

import java.util.List;

public class CarrinhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carrinho);

        //inicio
        RecyclerView recyclerView = findViewById(R.id.recycler);
        AppDataBaseCarrinho db = AppDataBaseCarrinho.getInstance(this);
        CarrinhoDao dao = db.carrinhoDao();
        List<CarrinhoEntity> carrinho = dao.getCarrinho();
        //System.out.println(dao.getCarrinho());
        recyclerView.setAdapter( new CarrinhoAdapter(carrinho,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);
    }
}