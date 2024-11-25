package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.Pedido;

public class Garcom extends Funcionario{

    public Garcom(String nome, String idFuncionario) {
        super(nome, idFuncionario);

    }
    @Override
    public void executarTarefa() {
        System.out.println("O garçom "+ getNome() +" está atendendo a mesa...");

    }
}
