package com.example.tagua.Carrinho;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tagua.Cardapio.CardapioEntity;

import java.util.List;

@Dao
public interface CarrinhoDao {
    @Query("SELECT * from carrinho")
    List<CarrinhoEntity> getCarrinho();
    @Query("SELECT * from carrinho WHERE id=:idcarrinho")
    List<CarrinhoEntity> buscarPoridcarrinho(int idcarrinho );
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insertAll(List<CarrinhoEntity> carrinho);
    @Query("DELETE FROM carrinho WHERE id = :idcarrinho")
    abstract void deletaItem(int idcarrinho);
    @Query("DELETE FROM carrinho")
    public void zeraCarrinho();
}
