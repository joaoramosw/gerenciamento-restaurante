package com.diogomnx.domain.restaurante;

import com.diogomnx.domain.pessoa.Cliente;

public class Reserva {
    private Cliente cliente;
    private String horario;

    public Reserva(Cliente cliente, String horario) {
        this.cliente = cliente;
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getHorario() {
        return horario;
    }

    public void confirmar() {
        System.out.println("Reserva confirmada para " + cliente.getNome() + " às " + horario + ".");
    }
}

