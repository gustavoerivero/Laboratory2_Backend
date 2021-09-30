package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Programa;

import java.util.List;

public interface ProgramaService {
    public Programa savePrograma(Programa programa);
    public List<String> getAllCodigosProgramas();
    public List<Programa> getAllProgramas();
    public Programa getProgramaById(int id);
    public Programa getProgramaByCode(String codigo);
    public String updatePrograma(Programa programa);
    public String deletePrograma(int id);
}
