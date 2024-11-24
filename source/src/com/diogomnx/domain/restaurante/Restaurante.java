package com.diogomnx.domain.restaurante;

import com.diogomnx.domain.compras.Cardapio;
import com.diogomnx.domain.pessoa.Funcionario;
import com.diogomnx.domain.compras.ItemCardapio;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private String endereco;
    private List<Mesa> mesas;
    private List<Funcionario> funcionarios;
    private Cardapio cardapio;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.mesas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.cardapio = new Cardapio();
    }

    public void inicializarSistema() {
        System.out.println("Sistema do restaurante " + nome + " inicializado.");
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void addItemCardapio(ItemCardapio item) {
        cardapio.addItem(item);
    }

    public void addMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", mesas=" + mesas +
                ", funcionarios=" + funcionarios +
                ", cardapio=" + cardapio +
                '}';
    }
}
