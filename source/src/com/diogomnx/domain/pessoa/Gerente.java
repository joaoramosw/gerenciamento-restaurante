package com.diogomnx.domain.pessoa;

public class Gerente extends Funcionario{
    public Gerente(String nome, String idFuncionario) {
        super(nome, idFuncionario);
    }
    @Override
    public void executarTarefa() {
        System.out.println("O gerente "+ super.getNome() +" está gerenciando as reservas...");
    }
}
