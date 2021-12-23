package com.daniel.memberapi.exceptions;

public class MembroAlreadyRegisteredException extends Exception {
    public MembroAlreadyRegisteredException(Long matricula) {
        super(String.format("O membro com a matrícula %d já está registrado.", matricula));
    }
}
