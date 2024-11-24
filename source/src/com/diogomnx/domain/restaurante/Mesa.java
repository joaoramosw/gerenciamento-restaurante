package com.diogomnx.domain.restaurante;

public class Mesa {
    private int numeroMesa;
    private int capacidade;
    private Reserva reserva;

    public Mesa(int numeroMesa, int capacidade) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.reserva = null;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isDisponivel() {
        return reserva == null;
    }

    public void reservar(Reserva reserva) {
        this.reserva = reserva;
    }

    public void liberar() {
        this.reserva = null;
    }

    public Reserva getReserva() {
        return reserva;
    }
}

