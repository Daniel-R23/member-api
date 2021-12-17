package com.daniel.memberapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daniel.memberapi.entity.Membro;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
}
