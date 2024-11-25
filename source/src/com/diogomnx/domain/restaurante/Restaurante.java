package com.diogomnx.domain.restaurante;

import com.diogomnx.domain.compras.Cardapio;
import com.diogomnx.domain.pessoa.Cliente;
import com.diogomnx.domain.pessoa.Funcionario;
import com.diogomnx.domain.compras.ItemCardapio;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private String endereco;
    private List<Mesa> mesas;
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    private Cardapio cardapio;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.mesas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.cardapio = new Cardapio();
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void addItemCardapio(ItemCardapio item) {
        this.cardapio.addItem(item);
    }

    public void addMesa(Mesa mesa) {
        this.mesas.add(mesa);
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void listarFuncionarios() {
        System.out.println("\n=== Lista de Funcionarios ===");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }
    }

    public Mesa buscarMesaDisponivel(int capacidade) {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponivel() && mesa.getCapacidade() >= capacidade) {
                return mesa;
            }
        }
        return null;
    }

    public void inicializarSistema() {
        System.out.println("Sistema do restaurante " + nome + " inicializado.");
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
