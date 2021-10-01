package com.dynamite.pensumsystem.repository;

import com.dynamite.pensumsystem.model.Departamento;
import com.dynamite.pensumsystem.model.Pensum;
import com.dynamite.pensumsystem.model.Programa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensumRepository extends JpaRepository<Pensum, Integer> {
    public Pensum findPensumByCodigo(String codigo);
    public List<Pensum> findPensumByPrograma(Programa programa);
    public List<Pensum> findPensumByDepartamento(Departamento departamento);
}
