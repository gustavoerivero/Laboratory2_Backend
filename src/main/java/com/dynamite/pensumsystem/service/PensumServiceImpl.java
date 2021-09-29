package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Pensum;
import com.dynamite.pensumsystem.repository.PensumRepository;
import com.dynamite.pensumsystem.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PensumServiceImpl implements PensumService{

    @Autowired
    private PensumRepository pensumRepository;
    
    @Autowired
    private ProgramaRepository programaRepository;

    public Pensum savePensum(Pensum pensum) {
        if(pensum != null)
            return pensumRepository.save(pensum);
        return new Pensum();
    }

    @Override
    public List<Pensum> getAllPensum() {
        return pensumRepository.findAll();
    }

    @Override
    public Pensum getPensumById(int id) {
        Optional<Pensum> pensum = pensumRepository.findById(id);
        return pensum.orElse(null);
    }

    @Override
    public Pensum getPensumByCodigo(String codigo) {
        return pensumRepository.findPensumByCodigo(codigo);
    }
    
    @Override
    public List<Pensum> getAllPensumByPrograma(String codigoPrograma) {
    	return pensumRepository.findPensumByPrograma(programaRepository.findProgramaByCodigo(codigoPrograma));
    }

    @Override
    public String updatePensum(Pensum pensum) {

        Optional<Pensum> pensumEncontrado = pensumRepository.findById(pensum.getId());
        if(pensumEncontrado.isPresent())
        {
            Pensum pensumActualizado = pensumEncontrado.get();
            pensumActualizado.setCodigo(pensum.getCodigo());
            pensumActualizado.setDescripcion(pensum.getDescripcion());
            pensumActualizado.setFecha(pensum.getFecha());
            pensumActualizado.setPrograma(pensum.getPrograma());
            pensumRepository.save(pensumActualizado);
            return "¡Datos del Pensum actualizados con exito!\n(Codigo del Pensum: " + pensum.getCodigo()+").";
        }
        return "Error: El Pensum no pudo ser actualizado.";
    }

    @Override
    public String deletePensum(int id) {
        Optional<Pensum> pensumEncontrado = pensumRepository.findById(id);
        if (pensumEncontrado.isPresent()) {
            pensumRepository.deleteById(id);
            return "Pensum " + pensumEncontrado.get().getCodigo() + " ha sido eliminado.";
        }
        return "Error: Pensum no encontrado.";
    }
}
