package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Departamento;
import com.dynamite.pensumsystem.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Departamento saveDepartamento(Departamento departamento) {
        if(departamento != null)
            return departamentoRepository.save(departamento);
        return new Departamento();
    }

    @Override
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento getDepartamentoById(int id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        return departamento.orElse(null);
    }

    @Override
    public List<String> getAllCodigosDepartamentos() {
        return departamentoRepository.getCodigoFromDepartamento();
    }

    @Override
    public List<String> getAllNombresDepartamentos() {
        return departamentoRepository.getNombreFromDepartamento();
    }

    @Override
    public Departamento getDepartamentoByCodigo(String codigo) {
        return departamentoRepository.findDepartamentoByCodigo(codigo);
    }

    @Override
    public String updateDepartamento(Departamento departamento) {
        Optional<Departamento> encontrarDepartamento = departamentoRepository.findById(departamento.getId());
        if (encontrarDepartamento.isPresent()) {
            Departamento departamentoActualizado = encontrarDepartamento.get();
            departamentoActualizado.setCodigo(departamento.getCodigo());
            departamentoActualizado.setNombre(departamento.getNombre());
            departamentoActualizado.setDescripcion(departamento.getDescripcion());
            departamentoActualizado.setStatus(departamento.getStatus());
            departamentoRepository.save(departamentoActualizado);
            return "¡Departamento actualizado con exito! (Codigo del Departamento: " + departamento.getCodigo()+").";
        }
        return "Error: El Departamento no pudo ser actualizado.";
    }

    @Override
    public String deleteDepartamento(int id) {
      Optional<Departamento> departamentoEncontrado = departamentoRepository.findById(id);
        if (departamentoEncontrado.isPresent()) {
            departamentoRepository.deleteById(id);
            return "Departamento " + departamentoEncontrado.get().getCodigo() + " ha sido eliminado.";
        }
        return "Error: Departamento no encontrado.";
    }
}
