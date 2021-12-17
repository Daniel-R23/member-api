package com.daniel.memberapi.service;

import com.daniel.memberapi.entity.Membro;
import com.daniel.memberapi.repository.MembroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

     public List<Membro> listAll(){
         return membroRepository.findAll();
    }
}
