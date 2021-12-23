package com.daniel.memberapi.controller;

import com.daniel.memberapi.dto.MembroDTO;
import com.daniel.memberapi.exceptions.MembroAlreadyRegisteredException;
import com.daniel.memberapi.exceptions.MembroNotFoundException;
import com.daniel.memberapi.service.MembroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@AllArgsConstructor
public class MembroController {

    private final MembroService membroService;

    @GetMapping
    public List<MembroDTO> listAll(){
        return membroService.listAll();
    }

    @GetMapping("/{id}")
    public MembroDTO findMember(@PathVariable Long id) throws MembroNotFoundException {
        return membroService.findMember(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createMember(@RequestBody MembroDTO membroDTO) throws MembroAlreadyRegisteredException {
        return membroService.createMember(membroDTO);
    }

    @PutMapping("/{id}")
    public String updateMember(@RequestBody MembroDTO membroDTO, @PathVariable Long id) throws MembroNotFoundException {
        return membroService.updateMember(id, membroDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable Long id) throws MembroNotFoundException {
        membroService.deleteMember(id);
    }
}
