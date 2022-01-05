package com.daniel.memberapi.dto;

import com.daniel.memberapi.entity.Endereco;
import com.daniel.memberapi.enums.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @JsonSerialize(using = LocalDateSerializer.class)
    @Nullable
    private LocalDate dataBatismo;

    @JsonSerialize(using = LocalDateSerializer.class)
    @Nullable
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull
    private GeneroEnum genero;

    @Enumerated(EnumType.STRING)
    @Nullable
    private EstadoCivilEnum estadoCivil;

    @Enumerated(EnumType.STRING)
    private Endereco endereco;

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
