package com.daniel.memberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cep;

    @Column
    private String logradouro;

    @Column
    private Long numero;

    @Column
    private String complemento;

    @Column
    private String bairro;

    @Column
    private String municipio;
}
