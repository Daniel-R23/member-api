package com.daniel.memberapi.entity;

import com.daniel.memberapi.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
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

    @Column
    private LocalDate dataBatismo;

    @Column
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroEnum genero;

    @Enumerated(EnumType.STRING)
    @Column
    private EstadoCivilEnum estadoCivil;

    @Enumerated(EnumType.STRING)
    @Column
    private ParentescoEnum parentesco;

    /* TODO: Pesquisar como fazer essa relação entre membro no banco de dados
    @Column
    private Membro parente;
    */
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
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
