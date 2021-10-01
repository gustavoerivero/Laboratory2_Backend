package com.dynamite.pensumsystem.repository;

import com.dynamite.pensumsystem.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    @Query(value = "SELECT codigo FROM departamento", nativeQuery = true)
    public List<String> getCodigoFromDepartamento();

    @Query(value = "SELECT nombre FROM departamento", nativeQuery = true)
    public List<String> getNombreFromDepartamento();
    
    @Query(value = "SELECT codigo, nombre FROM departamento", nativeQuery = true)
    public List<List<String>> getCodigoAndNombreFromDepartamento();

    public Departamento findDepartamentoByCodigo(String codigo);
}
