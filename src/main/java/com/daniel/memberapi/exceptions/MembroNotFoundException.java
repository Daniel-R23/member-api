package com.daniel.memberapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MembroNotFoundException extends Exception{
    public MembroNotFoundException(Long id){
        super("Não foi encontrado nenhum membro com o ID: " + id);
    }

}
