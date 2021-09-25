package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Pensum;
import com.dynamite.pensumsystem.repository.PensumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PensumServiceImpl implements PensumService{

    @Autowired
    private PensumRepository pensumRepository;

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
    public String updatePensum(Pensum pensum) {

        Optional<Pensum> pensumEncontrado = pensumRepository.findById(pensum.getPensumId());
        if(pensumEncontrado.isPresent())
        {
            Pensum pensumActualizado = pensumEncontrado.get();
            pensumActualizado.setCodigo(pensum.getCodigo());
            pensumActualizado.setNombre(pensum.getNombre());
            pensumActualizado.setDescripcion(pensum.getDescripcion());
            pensumActualizado.setFecha(pensum.getFecha());
            pensumActualizado.setCodPrograma(pensum.getCodPrograma());
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
            return "Pensum de " + pensumEncontrado.get().getNombre() +" ha sido eliminado.";
        }
        return "Error: Pensum no encontrado.";
    }
}
