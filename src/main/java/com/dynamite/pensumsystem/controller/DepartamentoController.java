package com.dynamite.pensumsystem.controller;

import com.dynamite.pensumsystem.model.Departamento;
import com.dynamite.pensumsystem.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping("/add")
    public String addDepartamento(@RequestBody Departamento departamento){
        departamentoService.saveDepartamento(departamento);
        return "Nuevo Departamento agregado satisfactoriamente.";
    }

    @GetMapping("/get")
    public List<Departamento> getAllDepartamentos(){
        return departamentoService.getAllDepartamentos();
    }

    @GetMapping("/get/codes")
    public List<String> getAllCodigosDepartamentos() {
        return departamentoService.getAllCodigosDepartamentos();
    }

    @GetMapping("/get/names")
    public List<String> getAllNombresDepartamentos() {
        return departamentoService.getAllNombresDepartamentos();
    }

    @GetMapping("/get/{id}")
    public Departamento readById(@PathVariable int id) {return departamentoService.getDepartamentoById(id);}

    @GetMapping("/get/codigo/{codigo}")
    public Departamento readByCodigo(@PathVariable String codigo) {return departamentoService.getDepartamentoByCodigo(codigo);}

    @PutMapping("/update/{codigo}")
    public String update(@PathVariable String codigo, @RequestBody Departamento departamento) {
        //Buscamos el ID por medio del codigo de departamento
        departamento.setId(departamentoService.getDepartamentoByCodigo(codigo).getId());

        //Pasamos el objeto con los nuevos datos
        return departamentoService.updateDepartamento(departamento);
    }

    @PutMapping("/update/id/{id}")
    public String updateById(@PathVariable int id, @RequestBody Departamento departamento) {
        //Buscamos el ID del departamento
        departamento.setId(id);

        //Pasamos el objeto con los nuevos datos
        return departamentoService.updateDepartamento(departamento);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return departamentoService.deleteDepartamento(id);
    }

}
