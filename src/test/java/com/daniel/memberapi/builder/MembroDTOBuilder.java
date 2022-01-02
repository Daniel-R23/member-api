package com.daniel.memberapi.builder;

import com.daniel.memberapi.dto.MembroDTO;
import com.daniel.memberapi.entity.Endereco;
import com.daniel.memberapi.enums.*;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class MembroDTOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private CategoriaMembroEnum categoria = CategoriaMembroEnum.MEMBRO;

    @Builder.Default
    private Long matricula = 1234L;

    @Builder.Default
    private String nome = "MembroTeste";

    @Builder.Default
    private LocalDate dataBatismo = LocalDate.of(2015,11,7);

    @Builder.Default
    private LocalDate dataNascimento = LocalDate.of(2001,5,23);

    @Builder.Default
    private GeneroEnum genero = GeneroEnum.MASCULINO;

    @Builder.Default
    private EstadoCivilEnum estadoCivil = EstadoCivilEnum.CASADO;

    @Builder.Default
    private Endereco endereco = null;
    //private Endereco endereco = new Endereco(1L,"61936130","Rua 113",421L, "Apt B", "Timbó", "Maracanaú");

    @Builder.Default
    private String telefone = "8599999999";

    @Builder.Default
    private String profissao = "profissaoTeste";

    @Builder.Default
    private CargoEnum cargo = CargoEnum.PRESBITERO;

    @Builder.Default
    private MinisterioEnum ministerio = MinisterioEnum.ENSINO;

    @Builder.Default
    private boolean recebeVisitas = true;

    @Builder.Default
    private boolean recebeOracoes = true;

    public MembroDTO toMembroDTO(){
        return new MembroDTO(
                id,
                categoria,
                matricula,
                nome,
                dataBatismo,
                dataNascimento,
                genero,
                estadoCivil,
                endereco,
                telefone,
                profissao,
                cargo,
                ministerio,
                recebeVisitas,
                recebeOracoes
        );
    }
}
