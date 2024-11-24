package com.diogomnx.application;

import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.pessoa.Cliente;
import com.diogomnx.domain.pessoa.Garcom;
import com.diogomnx.domain.restaurante.Mesa;
import com.diogomnx.domain.restaurante.Reserva;
import com.diogomnx.domain.restaurante.Restaurante;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Restaurante restaurante = new Restaurante("Snoop Burguer", "Rua 09, 27");

        System.out.println("Bem vindo ao sistema geral do Snoop Burguer!");

        System.out.println("Adicione mesas ao restaurante (Digite 0 para finalizar):");
        while (true) {
            System.out.print("Número da mesa: ");
            int numeroMesa = input.nextInt();
            if (numeroMesa == 0) break;

            System.out.print("Capacidade da mesa: ");
            int capacidade = input.nextInt();

            restaurante.addMesa(new Mesa(numeroMesa, capacidade));
        }
        System.out.println("Adicione itens ao cardápio (Deixe o nome vazio caso queira finalizar o cadastramento de alimentos");
        while (true) {
            System.out.print("Nome do item: ");
            String nome = input.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Finalizando adição de itens.");
                break;
            }

            System.out.print("Preço do item: ");
            double preco = input.nextDouble();

            System.out.print("Categoria do item: ");
            String categoria = input.nextLine();
            input.nextLine();

            System.out.println("===========");

            restaurante.addItemCardapio(new ItemCardapio(nome, preco, categoria));
        }

        restaurante.inicializarSistema();

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = input.next();

        Cliente cliente = new Cliente(nomeCliente);
        Garcom garcom = new Garcom("Pedro", "G01");

        System.out.println("\nDigite a capacidade necessária para a mesa:");
        int capacidadeNecessaria = input.nextInt();
        Mesa mesaDisponivel = restaurante.buscarMesaDisponivel(capacidadeNecessaria);

        if (mesaDisponivel != null) {
            System.out.println("Mesa " + mesaDisponivel.getNumeroMesa() + " está disponível. Reservando...");
            System.out.print("Digite o horário da reserva: ");
            String horarioReserva = input.nextLine();
            input.nextLine();

            Reserva reserva = new Reserva(cliente, horarioReserva);
            mesaDisponivel.reservar(reserva);
            reserva.confirmar();
        } else {
            System.out.println("Desculpe, não há mesas disponíveis para esse número de pessoas.");
            return;
        }

        cliente.fazerPedido(restaurante.getCardapio(), input);
        garcom.executarTarefa();

        System.out.println("\nEscolha uma forma de pagamento:");
        System.out.println("1. Dinheiro\n2. Cartão\n3. Pix");
        System.out.println("(Digite o numero referente ao método de pagamento");
        int escolhaPagamento = input.nextInt();

        switch (escolhaPagamento) {
            case 1 -> cliente.pagarComDinheiro(input);
            case 2 -> cliente.pagarComCartao(input);
            case 3 -> cliente.pagarComPix(input);
            default -> System.out.println("Forma de pagamento inválida.");
        }

        mesaDisponivel.liberar();
        System.out.println("Mesa " + mesaDisponivel.getNumeroMesa() + " está agora disponível.");
        
        System.out.println("Obrigado por visitar o Snoop Burguer e volte sempre!");
    }

}

