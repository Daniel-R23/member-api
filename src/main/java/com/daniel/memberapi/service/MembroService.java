package com.daniel.memberapi.service;

import com.daniel.memberapi.entity.Membro;
import com.daniel.memberapi.exceptions.MembroNotFoundException;
import com.daniel.memberapi.repository.MembroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

     public List<Membro> listAll(){
         return membroRepository.findAll();
    }

    public Membro findMember(Long id) throws MembroNotFoundException {
        Optional<Membro> member = membroRepository.findById(id);
        return verifyIfExists(id);
    }

    private Membro verifyIfExists(Long id) throws MembroNotFoundException {
         return membroRepository.findById(id).orElseThrow(()-> new MembroNotFoundException(id));
    }

    public String createMember(Membro membro) {
        Membro savedMembro = membroRepository.save(membro);
        return ("Membro criado com sucesso com o ID: " + savedMembro.getId());
    }
}
