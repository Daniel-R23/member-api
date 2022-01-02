package com.daniel.memberapi.entity;

import com.daniel.memberapi.enums.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaMembroEnum categoria;

    @Column(unique = true)
    private Long matricula;

    @Column(nullable = false)
    private String nome;

    @JsonSerialize(using = LocalDateSerializer.class)
    @Column
    private LocalDate dataBatismo;

    @JsonSerialize(using = LocalDateSerializer.class)
    @Column
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroEnum genero;

    @Enumerated(EnumType.STRING)
    @Column
    private EstadoCivilEnum estadoCivil;

    @ManyToOne
    @JoinColumn
    private Endereco endereco;

    @Column
    private String telefone;

    @Column
    private String profissao;

    @Enumerated(EnumType.STRING)
    @Column
    private CargoEnum cargo;

    @Enumerated(EnumType.STRING)
    @Column
    private MinisterioEnum ministerio;

    @Column
    private boolean recebeVisitas;

    @Column
    private boolean recebeOracoes;
}
