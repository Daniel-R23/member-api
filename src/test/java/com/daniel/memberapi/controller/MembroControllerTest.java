package com.daniel.memberapi.controller;

import com.daniel.memberapi.builder.MembroDTOBuilder;
import com.daniel.memberapi.dto.MembroDTO;
import com.daniel.memberapi.entity.Membro;
import com.daniel.memberapi.mapper.MembroMapper;
import com.daniel.memberapi.repository.MembroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class MembroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MembroRepository membroRepository;

    private final MembroMapper membroMapper = MembroMapper.INSTANCE;

    @Order(1)
    @Test
    void whenMemberInformedThenItShouldBeCreated() throws Exception {
        MembroDTO expectedMembro = MembroDTOBuilder.builder().build().toMembroDTO();
        Membro expectedSavedMembro = membroMapper.toModel(expectedMembro);

        membroRepository.save(expectedSavedMembro);

        mockMvc
                .perform(MockMvcRequestBuilders.post("/api/v1/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(expectedSavedMembro)))
                        .andExpect(status().is(HttpStatus.CREATED.value()));
    }

    @Order(2)
    @Test
    void whenCalledThenReturnAllMembers() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/members")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Order(3)
    @Test
    void whenCalledThenReturnNotFoundedStatus() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/members/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Order(4)
    @Test
    void whenMemberUpdatedThenItShouldBeSaved() throws Exception {
        MembroDTO expectedUpdatedMembro = MembroDTOBuilder.builder().build().toMembroDTO();

        mockMvc
                .perform(MockMvcRequestBuilders.put("/api/v1/members/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectedUpdatedMembro)))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Order(5)
    @Test
    void whenMemberIdInformedThenItShouldBeDeleted() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.delete("/api/v1/members/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.NO_CONTENT.value()));
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
