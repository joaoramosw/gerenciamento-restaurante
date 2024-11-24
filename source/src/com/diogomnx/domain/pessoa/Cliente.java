package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.ItemCardapio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa{

    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String infoContato) {
        super(nome, infoContato);
    }

//    public void fazerPedido(Cardapio cardapio, Garcom garcom) {
//
//    }

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

    public void pagarComCarteiraDigital(Scanner input) {
        System.out.println("Insira o ID da carteira digital:");
        String carteiraId = input.next();
        System.out.println("Pagamento processado via carteira de digital: " + carteiraId + ". Obrigado!");
    }

    public void pagarComPix(Scanner input) {
        System.out.println("Gerando chave aleatória...");

        String pix = input.next();
        System.out.println("Pagamento processado via Pix. Obrigado!");
    }
}
