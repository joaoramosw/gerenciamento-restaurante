package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.Pedido;

public class Garcom extends Funcionario{

    public Garcom(String nome, String idFuncionario) {
        super(nome, idFuncionario);

    }
//    public void receberPedido(Pedido pedido) {
//        System.out.println("Recebendo pedido: " + pedido);
//    }
//    public void servirPrato(Pedido pedido) {
//        System.out.println("Garçom " + super.getNome() + " está servindo o pedido: " + pedido);
//    }
    @Override
    public void executarTarefa() {
        System.out.println("O garçom "+ super.getNome() +" está atendendo a mesa...");

    }
}
