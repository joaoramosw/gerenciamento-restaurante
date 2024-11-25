package com.diogomnx.application;

import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.pessoa.Cliente;
import com.diogomnx.domain.pessoa.Garcom;
import com.diogomnx.domain.restaurante.Mesa;
import com.diogomnx.domain.restaurante.Reserva;
import com.diogomnx.domain.restaurante.Restaurante;
import com.diogomnx.domain.restaurante.SistemaRestaurante;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Restaurante restaurante = new Restaurante("Snoop Burguer", "Rua 09, 27");
        SistemaRestaurante sistema = new SistemaRestaurante(restaurante);

        System.out.println("Bem vindo ao sistema geral do Snoop Burguer!");

        int opcao;
        do {
            System.out.println("\n=== Sistema Snoop Burguer ===");
            System.out.println("1. Adicionar mesa");
            System.out.println("2. Listar mesas");
            System.out.println("3. Listar mesas ordenadas por capacidade");
            System.out.println("4. Buscar mesa por capacidade");
            System.out.println("5. Adicionar item ao cardapio");
            System.out.println("6. Listar Cardápio");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1 -> sistema.adicionarMesa(input);
                case 2 -> sistema.listarMesas();
                case 3 -> sistema.listarMesasOrdenadas();
                case 4 -> sistema.buscarMesaPorCapacidade(input);
                case 5 -> sistema.adicionarItemCardapio(restaurante, input);
                case 6 -> sistema.listarCardapio(restaurante);
                case 7 -> sistema.adicionarFuncionario(input);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        System.out.println("=================");

        restaurante.inicializarSistema();

        System.out.println("==================");

        boolean maisClientes = true;
        while (maisClientes) {
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = input.next();
            Cliente cliente = new Cliente(nomeCliente);
            Garcom garcom = new Garcom("Pedro", "G01");

            boolean continuar = true;
            while (continuar) {
                System.out.println("\nDigite a capacidade necessária para a mesa:");
                int capacidadeNecessaria = input.nextInt();
                Mesa mesaDisponivel = restaurante.buscarMesaDisponivel(capacidadeNecessaria);

                if (mesaDisponivel != null) {
                    System.out.println("Mesa " + mesaDisponivel.getNumeroMesa() + " está disponível. Reservando...");
                    System.out.print("Digite o horário da reserva: ");
                    String horarioReserva = input.next();

                    Reserva reserva = new Reserva(cliente, horarioReserva);
                    mesaDisponivel.reservar(reserva);
                    reserva.confirmar();
                    continuar = false;
                } else {
                    System.out.println("Desculpe, não há mesas disponíveis para esse número de pessoas.");
                    System.out.println("Deseja tentar novamente? (s/n)");
                    char respostaReserva = input.next().charAt(0);
                    if (respostaReserva == 'n') {
                        System.out.println("Finalizando programa.");
                        continuar = false;
                    }
                }

                garcom.executarTarefa();

                cliente.fazerPedido(restaurante.getCardapio(), input);

                System.out.println("================");

                System.out.println("\nEscolha uma forma de pagamento:");
                System.out.println("1. Dinheiro\n2. Cartão\n3. Pix");
                System.out.println("(Digite o numero referente ao método de pagamento)");
                int escolhaPagamento = input.nextInt();

                switch (escolhaPagamento) {
                    case 1 -> cliente.pagarComDinheiro(input);
                    case 2 -> cliente.pagarComCartao(input);
                    case 3 -> cliente.pagarComPix(input);
                    default -> System.out.println("Forma de pagamento inválida.");
                }

                mesaDisponivel.liberar();
                System.out.println("==================");
                System.out.println("Mesa " + mesaDisponivel.getNumeroMesa() + " está agora disponível.");

                System.out.println("Mais algum cliente? (s/n)");
                char respostaCliente = input.next().charAt(0);
                if (respostaCliente == 'n') {
                    maisClientes = false;
                }
            }
        }

        System.out.println("==============");

        System.out.println("Obrigado por visitar o Snoop Burguer e volte sempre!");
    }
}

