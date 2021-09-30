package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Programa;
import com.dynamite.pensumsystem.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;

    @Override
    public Programa savePrograma(Programa programa){
        if(programa != null)
            return programaRepository.save(programa);
        return new Programa();
    }
    
    @Override
    public List<String> getAllCodigosProgramas() {
    	return programaRepository.getCodigoFromPrograma();
    }

    @Override
    public List<Programa> getAllProgramas() {
        return programaRepository.findAll();
    }

    @Override
    public Programa getProgramaById(int id){
        Optional<Programa> programa = programaRepository.findById(id);
        return programa.orElse(null);
    }

    @Override
    public Programa getProgramaByCode(String codigo){
        return programaRepository.findProgramaByCodigo(codigo);
    }

    @Override
    public String updatePrograma(Programa programa){
        Optional<Programa> encontrarPrograma = programaRepository.findById(programa.getId());
        if (encontrarPrograma.isPresent()) {
            Programa programaActualizado = encontrarPrograma.get();
            programaActualizado.setCodigo(programa.getCodigo());
            programaActualizado.setNombre(programa.getNombre());
            programaActualizado.setStatus(programa.getStatus());
            programaRepository.save(programaActualizado);
            return "¡Programa actualizado con exito! (Programa codigo: " + programa.getCodigo()+").";
        }
        return "Error: El Programa no pudo ser actualizado.";
    }

    @Override
    public String deletePrograma(int id){
        if (programaRepository.findById(id).isPresent()) {
            programaRepository.deleteById(id);
            return "Programa ID: " + id +" ha sido eliminado.";
        }
        return "Error: Programa no encontrado.";
    }
    
}
