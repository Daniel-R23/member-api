package com.daniel.memberapi.services;

import com.daniel.memberapi.entity.Membro;
import com.daniel.memberapi.repository.MembroRepository;

import java.util.List;

public class MembroService {

    private MembroRepository membroRepository;

     public List<Membro> listAll(){
         return (List<Membro>) membroRepository.findAll();
    }
}
