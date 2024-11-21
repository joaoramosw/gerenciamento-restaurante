package com.diogomnx.domain.pessoa;

public abstract class Pessoa {
    private String nome;
    private String infoContato;
    private String detalhes;

    public Pessoa(String nome, String infoContato, String detalhes) {
        this.nome = nome;
        this.infoContato = infoContato;
        this.detalhes = detalhes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInfoContato() {
        return infoContato;
    }

    public void setInfoContato(String infoContato) {
        this.infoContato = infoContato;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
