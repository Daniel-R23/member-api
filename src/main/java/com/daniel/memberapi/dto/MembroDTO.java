package com.daniel.memberapi.dto;

import com.daniel.memberapi.enums.*;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembroDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CategoriaMembroEnum categoria;

    @Nullable
    private Long matricula;

    @NotNull
    private String nome;

    @Nullable
    private LocalDate dataBatismo;

    @Nullable
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull
    private GeneroEnum genero;

    @Enumerated(EnumType.STRING)
    @Nullable
    private EstadoCivilEnum estadoCivil;
    /*
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Endereco endereco;
    */
    @Nullable
    private String telefone;

    @Nullable
    private String profissao;

    @Enumerated(EnumType.STRING)
    @Nullable
    private CargoEnum cargo;

    @Enumerated(EnumType.STRING)
    @Nullable
    private MinisterioEnum ministerio;

    @Nullable
    private boolean recebeVisitas;

    @Nullable
    private boolean recebeOracoes;
}
