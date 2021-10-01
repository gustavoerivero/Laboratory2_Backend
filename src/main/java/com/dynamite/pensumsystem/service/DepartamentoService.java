package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Departamento;

import java.util.List;

public interface DepartamentoService {
    public Departamento saveDepartamento(Departamento departamento);
    public List<Departamento> getAllDepartamentos();
    public Departamento getDepartamentoById(int id);
    public List<String> getAllCodigosDepartamentos();
    public List<String> getAllNombresDepartamentos();
    public Departamento getDepartamentoByCodigo(String codigo);
    public String updateDepartamento(Departamento departamento);
    public String deleteDepartamento(int id);
}
