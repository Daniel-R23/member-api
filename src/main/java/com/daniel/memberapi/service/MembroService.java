package com.daniel.memberapi.service;

import com.daniel.memberapi.dto.MembroDTO;
import com.daniel.memberapi.entity.Membro;
import com.daniel.memberapi.exceptions.MembroAlreadyRegisteredException;
import com.daniel.memberapi.exceptions.MembroNotFoundException;
import com.daniel.memberapi.mapper.MembroMapper;
import com.daniel.memberapi.repository.MembroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;
    private final MembroMapper membroMapper = MembroMapper.INSTANCE;

     public List<MembroDTO> listAll(){
         return membroRepository.findAll()
                 .stream()
                 .map(membroMapper::toDTO)
                 .collect(Collectors.toList());
    }

    public MembroDTO findMember(Long id) throws MembroNotFoundException {
        Membro foundMember = membroRepository.findById(id)
                .orElseThrow(()-> new MembroNotFoundException(id));
        return membroMapper.toDTO(foundMember);
    }

    public String createMember(MembroDTO membroDTO) throws MembroAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(membroDTO.getMatricula());
        Membro membro = membroMapper.toModel(membroDTO);
        Membro savedMembro = membroRepository.save(membro);
        return ("Membro criado com sucesso com o ID: " + savedMembro.getId());
    }

    public String updateMember(Long id, MembroDTO membroDTO) throws MembroNotFoundException {
        verifyIfExists(id);
        Membro membro = membroMapper.toModel(membroDTO);
        Membro updatedMembro = membroRepository.save(membro);
        return ("Informações atualizadas com sucesso no membro com o ID: " + updatedMembro.getId());
    }

    public void deleteMember(Long id) throws MembroNotFoundException {
         verifyIfExists(id);
         membroRepository.deleteById(id);
    }

    private Membro verifyIfExists(Long id) throws MembroNotFoundException {
         return membroRepository.findById(id).orElseThrow(()-> new MembroNotFoundException(id));
    }

    private void verifyIfIsAlreadyRegistered(Long matricula) throws MembroAlreadyRegisteredException {
        Optional<Membro> optSavedMember = membroRepository.findByMatricula(matricula);
        if(optSavedMember.isPresent()){
            throw new MembroAlreadyRegisteredException(matricula);
        }
    }
}
