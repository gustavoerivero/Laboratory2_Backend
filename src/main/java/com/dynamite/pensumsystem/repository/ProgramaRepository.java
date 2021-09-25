package com.dynamite.pensumsystem.repository;

import com.dynamite.pensumsystem.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Integer> {
    public Programa findProgramaByCodigo(String codigo);
}
