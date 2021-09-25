package com.dynamite.pensumsystem.controller;

import com.dynamite.pensumsystem.model.Programa;
import com.dynamite.pensumsystem.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @PostMapping("/add")
    public String addPrograma(@RequestBody Programa programa){
        programaService.savePrograma(programa);
        return "Nuevo Programa agregado satisfactoriamente.";
    }

    @GetMapping("/getAllPrograms")
    public List<Programa> getAllProgramas(){
        return programaService.getAllProgramas();
    }

    @GetMapping("/get/{id}")
    public Programa readById(@PathVariable int id) {return programaService.getProgramaById(id);}

    @PutMapping("/update/{codigo}")
    public String update(@PathVariable String codigo, @RequestBody Programa programa) {
        //Buscamos el ID por medio del Username
        programa.setProgramaId(programaService.getProgramaByCode(codigo).getProgramaId());

        //Pasamos el objeto con los nuevos datos
        return programaService.updatePrograma(programa);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return programaService.deletePrograma(id);
    }
}
