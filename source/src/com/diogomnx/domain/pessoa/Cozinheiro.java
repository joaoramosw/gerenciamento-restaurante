package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.compras.Pedido;

public class Cozinheiro extends Funcionario{

    public Cozinheiro(String nome, String idFuncionario) {
            super(nome, idFuncionario);
    }

    @Override
    public void executarTarefa() {
        System.out.println("O cozinheiro "+ getNome() +" está preparando o pedido.");
    }
}
