package com.diogomnx.domain.pessoa;

public class Garcom extends Funcionario{

    public Garcom(String nome, String infoContato, String idFuncionario) {
        super(nome, infoContato, idFuncionario);

    }
    public void receberPedido(Pedido pedido) {
        System.out.println("Recebendo pedido: " + pedido);
    }
    public void servirPrato(Pedido pedido) {
        System.out.println("Garçom " + super.getNome() + " está servindo o pedido: " + pedido);
    }
}
