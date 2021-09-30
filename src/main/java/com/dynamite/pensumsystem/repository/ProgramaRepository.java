package com.dynamite.pensumsystem.repository;

import com.dynamite.pensumsystem.model.Programa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Integer> {
    public Programa findProgramaByCodigo(String codigo);
    @Query(value = "SELECT codigo FROM programa", nativeQuery = true)
    public List<String> getCodigoFromPrograma();
}
