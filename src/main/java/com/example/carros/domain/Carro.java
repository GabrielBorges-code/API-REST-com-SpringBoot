package com.example.carros.domain;

import javax.persistence.*;

@Entity
public class Carro {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    public Carro(){

    }

    //@Column(name = "nome coluna")
    private String nome;

    public Carro(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
