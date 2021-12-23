package com.daniel.memberapi.mapper;

import com.daniel.memberapi.dto.MembroDTO;
import com.daniel.memberapi.entity.Membro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MembroMapper {

    MembroMapper INSTANCE = Mappers.getMapper(MembroMapper.class);

    Membro toModel(MembroDTO membroDTO);

    MembroDTO toDTO(Membro membro);
}
