package com.daniel.memberapi.controller;

import com.daniel.memberapi.entity.Membro;
import com.daniel.memberapi.exceptions.MembroNotFoundException;
import com.daniel.memberapi.service.MembroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Membro findMember(@PathVariable Long id) throws MembroNotFoundException {
        return membroService.findMember(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createMember(@RequestBody Membro membro){
        return membroService.createMember(membro);
    }

    @PutMapping("/{id}")
    public String updateMember(@RequestBody Membro membro, @PathVariable Long id) throws MembroNotFoundException {
        return membroService.updateMember(id, membro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable Long id) throws MembroNotFoundException {
        membroService.deleteMember(id);
    }
}
