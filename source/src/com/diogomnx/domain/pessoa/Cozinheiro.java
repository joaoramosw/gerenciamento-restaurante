package com.diogomnx.domain.pessoa;

public class Cozinheiro extends Funcionario{

    public Cozinheiro(String nome, String infoContato, String idFuncionario) {
            super(nome, infoContato, idFuncionario);
    }

    public void prepararPrato(String itemCardapio, Pedido pedido) {
        System.out.println("Chefe " + getNome() + " está preparando o prato: " + itemCardapio + " do pedido " + pedido);
    }
}
