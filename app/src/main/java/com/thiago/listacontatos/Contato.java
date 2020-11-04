package com.thiago.listacontatos;

public class Contato {

    private int id;
    private String nome;
    private String numero;
    private String email;

    @Override
    public String toString() {
        return nome + " - " +  numero;          //apresentando o contato  e o numero de telefone
    }

    public Contato() {
        // construtor para quando não tiver nenhum contato, quando quiser criar um novo contato
    }

    public Contato(String nome, String numero, String email) {
        this.nome = nome;
        this.numero = numero;       //quando o contato não estiver no banco sera gerado um ID
        this.email = email;
    }

    public Contato(int id, String nome, String numero, String email) {
        this.id = id;
        this.nome = nome;           //caso exista o contato no banco, ja tem um ID usa esse metodo
        this.numero = numero;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}