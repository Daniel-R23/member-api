package com.daniel.memberapi.controller;

import com.daniel.memberapi.entity.Membro;
import com.daniel.memberapi.service.MembroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@AllArgsConstructor
public class MembroController {

    @Autowired
    private MembroService membroService;

    @GetMapping
    public List<Membro> listAll(){
        return membroService.listAll();
    }
}
