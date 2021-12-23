package com.daniel.memberapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daniel.memberapi.entity.Membro;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    Optional<Membro> findByMatricula(Long matricula);
}
