package com.example.carros.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
/*@Getter @Setter
@ToString
@EqualsAndHashCode*/
public class Carro {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;

}
