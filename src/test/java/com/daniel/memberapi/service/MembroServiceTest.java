package com.daniel.memberapi.service;

import com.daniel.memberapi.dto.MembroDTO;
import com.daniel.memberapi.entity.Membro;
import com.daniel.memberapi.repository.MembroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest(classes = {
        MembroService.class
})
class MembroServiceTest {

    @MockBean
    MembroRepository membroRepository;

    @Autowired
    MembroService membroService;

    @Test
    void listAll() {
        //o que preciso
        when(membroRepository.findAll()).thenReturn(List.of(new Membro()));
        //chamada
        List<MembroDTO> lista = membroService.listAll();
        //verifica retorno
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    void findMember() {
    }

    @Test
    void createMember() {
    }

    @Test
    void updateMember() {
    }

    @Test
    void deleteMember() {
    }
}