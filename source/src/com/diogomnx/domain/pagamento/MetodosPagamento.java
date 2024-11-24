package com.diogomnx.domain.pagamento;

import java.util.Scanner;

public interface MetodosPagamento {
    void pagarComDinheiro(Scanner input);
    void pagarComCartao(Scanner input);
    void pagarComPix(Scanner input);
}
