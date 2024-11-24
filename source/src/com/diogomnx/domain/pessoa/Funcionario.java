package com.diogomnx.domain.pessoa;

public class Funcionario extends Pessoa {

    private String idFuncionario;

    // Construtor
    public Funcionario(String nome, String infoContato, String idFuncionario) {
        super(nome, infoContato);
        this.idFuncionario = idFuncionario;
    }

    // Getter e Setter
    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    // Método para realizar uma tarefa
    public void realizarTarefa() {
        System.out.println("Funcionario " + getNome() + " está realizando uma tarefa.");
    }

}
