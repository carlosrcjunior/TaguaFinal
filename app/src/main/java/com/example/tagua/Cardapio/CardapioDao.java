package com.example.tagua.Cardapio;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface CardapioDao {
    @Query("SELECT * from cardapio")
    List<CardapioEntity> getCardapio();
    @Query("SELECT * from cardapio WHERE id=:idcardapio")
    List<CardapioEntity> buscarPoridcardapio( int idcardapio );
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insertAll(List<CardapioEntity> cardapio);
}
