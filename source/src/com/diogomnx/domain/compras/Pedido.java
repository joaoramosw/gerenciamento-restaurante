package com.diogomnx.domain.compras;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemCardapio> itens = new ArrayList<>();
    private Double valorTotal;

    public void addItem(ItemCardapio item){

    }

    public double calcularTotal(){
        return 0;
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public void setItens(List<ItemCardapio> itens) {
        this.itens = itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
