package com.diogomnx.domain.pessoa;

public class Gerente extends Funcionario{
    public Gerente(String nome, String infoContato, String idFuncionario) {
        super(nome, infoContato, idFuncionario);
    }
    public void gerenciarReserva(Reserva reserva) {
    }
}
