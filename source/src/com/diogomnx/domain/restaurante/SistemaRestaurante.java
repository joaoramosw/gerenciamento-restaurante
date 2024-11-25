package com.diogomnx.domain.restaurante;

import com.diogomnx.domain.compras.ItemCardapio;

import java.util.Scanner;

public class SistemaRestaurante {
    private final Restaurante restaurante;

    public SistemaRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void adicionarMesa(Scanner input) {
        System.out.print("Número da Mesa: ");
        int numero = input.nextInt();
        System.out.print("Capacidade da Mesa: ");
        int capacidade = input.nextInt();
        restaurante.addMesa(new Mesa(numero, capacidade));
        System.out.println("Mesa adicionada com sucesso.");
    }

    public void listarMesas() {
        System.out.printf("%-10s %-15s\n", "Número", "Capacidade");
        for (Mesa mesa : restaurante.getMesas()) {
            System.out.printf("%-10d %-15d\n", mesa.getNumeroMesa(), mesa.getCapacidade());
        }
    }

    public void listarMesasOrdenadas() {
        restaurante.getMesas().sort((m1, m2) -> Integer.compare(m1.getCapacidade(), m2.getCapacidade()));
        listarMesas();
    }

    public void buscarMesaPorCapacidade(Scanner input) {
        System.out.print("Capacidade mínima: ");
        int capacidade = input.nextInt();
        Mesa mesa = restaurante.buscarMesaDisponivel(capacidade);
        if (mesa != null) {
            System.out.println("Mesa encontrada: " + mesa.getNumeroMesa() + " com capacidade de " + mesa.getCapacidade());
        } else {
            System.out.println("Nenhuma mesa encontrada com essa capacidade.");
        }
    }

    public void adicionarItemCardapio(Restaurante restaurante, Scanner input) {
        input.nextLine();
        System.out.print("Nome do Item: ");
        String nome = input.nextLine();
        System.out.print("Preço do Item: ");
        double preco = input.nextDouble();
        input.nextLine();
        System.out.print("Categoria do Item: ");
        String categoria = input.nextLine();
        restaurante.addItemCardapio(new ItemCardapio(nome, preco, categoria));
        System.out.println("Item adicionado ao cardápio.");
    }

    public void listarCardapio(Restaurante restaurante) {
        System.out.printf("%-20s %-10s %-15s\n", "Nome", "Preço", "Categoria");
        for (var item : restaurante.getCardapio().getItens()) {
            System.out.printf("%-20s R$%-10.2f %-15s\n", item.getNome(), item.getPreco(), item.getCategoria());
        }
    }
}