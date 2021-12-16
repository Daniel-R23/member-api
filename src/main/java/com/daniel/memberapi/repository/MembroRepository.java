package com.daniel.memberapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daniel.memberapi.entity.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {
}
