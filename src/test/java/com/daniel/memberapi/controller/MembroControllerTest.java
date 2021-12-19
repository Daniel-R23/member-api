package com.daniel.memberapi.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class MembroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(2)
    void listAll() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/members")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                //.andExpect(jsonPath("$.error").value("Access is denied"));
    }

    @Test
    void findMember() {
    }

    @Test
    @Order(1)
    void createMember() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.post("/api/v1/members")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().is(HttpStatus.OK.value()))
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                        //.andExpect(jsonPath("$.error").value("Access is denied"));
    }

    @Test
    void updateMember() {
    }

    @Test
    void deleteMember() {
    }
}