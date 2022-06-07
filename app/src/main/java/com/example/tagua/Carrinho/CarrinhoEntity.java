package com.example.tagua.Carrinho;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "carrinho")
public class CarrinhoEntity {
    @PrimaryKey
    private int id;
    private int valor;
    private String descricao;

    public CarrinhoEntity(int id, int valor, String descricao){
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return "CarrinhoEntity{" +
                "id=" + id +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
