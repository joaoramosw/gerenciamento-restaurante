package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.compras.Pedido;

public abstract class Funcionario extends Pessoa {

    private String idFuncionario;

    public Funcionario(String nome, String idFuncionario) {
        super(nome);
        this.idFuncionario = idFuncionario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public abstract void executarTarefa();
}
