package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.Cardapio;
import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.compras.Pedido;
import com.diogomnx.domain.pagamento.MetodosPagamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa implements MetodosPagamento {

    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome) {
        super(nome);
        this.pedidos = new ArrayList<>();
    }

    public void fazerPedido(Cardapio cardapio, Scanner input) {
        Pedido pedido = new Pedido();
        System.out.println("\nCardápio:");
        int i = 1;
        for (ItemCardapio item : cardapio.getItens()) {
            System.out.println(i++ + ". " + item.getNome() + " - R$ " + item.getPreco());
        }
        System.out.println("Digite o número do item para adicionar ao pedido (ou 0 para finalizar):");
        while (true) {
            int escolha = input.nextInt();
            if (escolha == 0) break;
            if (escolha > 0 && escolha <= cardapio.getItens().size()) {
                pedido.addItem(cardapio.getItens().get(escolha - 1));
                System.out.println(cardapio.getItens().get(escolha - 1).getNome() + " adicionado ao pedido.");
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }
        pedidos.add(pedido);
        System.out.println("Pedido finalizado. Total: R$ " + pedido.calcularTotal());
    }

    public void pagarComDinheiro(Scanner input) {
        System.out.println("Insira o valor em dinheiro:");
        double dinheiro = input.nextDouble();
        System.out.println("Pagamento de R$" + dinheiro + " recebido em dinheiro. Obrigado!");
    }

    public void pagarComCartao(Scanner input) {
        System.out.println("Insira o numero do cartao:");
        String numeroCartao = input.next();
        System.out.println("Pagamento processado com cartao de final " + numeroCartao.substring(numeroCartao.length() - 4) + ". Obrigado!");
    }

    public void pagarComPix(Scanner input) {
        System.out.println("Gerando chave aleatória...");
        input.nextLine();
        System.out.println("Pagamento processado via Pix. Obrigado!");
    }
}
