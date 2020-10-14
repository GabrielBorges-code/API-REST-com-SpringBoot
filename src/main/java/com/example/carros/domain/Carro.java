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
    private String descricao;
    private String url_foto;
    private String url_video;
    private String latitude;
    private String longitude;

}
