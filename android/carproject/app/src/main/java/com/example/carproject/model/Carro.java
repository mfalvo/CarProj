package com.example.carproject.model;

import java.util.Objects;

public class Carro {

    private Long id; // Identificador único do carro
    private String marca; // Marca do carro
    private String nome; // Nome do carro
    private int ano; // Ano do carro
    private String cor; // Cor do carro


    public Carro() {
    }

    public Carro(Long id, String marca, String nome, int ano, String cor) {
        this.id = id;
        this.marca = marca;
        this.nome = nome;
        this.ano = ano;
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return ano == carro.ano && Objects.equals(id, carro.id) && Objects.equals(marca, carro.marca) && Objects.equals(nome, carro.nome) && Objects.equals(cor, carro.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, nome, ano, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                '}';
    }
}
