package com.dynamite.pensumsystem.controller;

import com.dynamite.pensumsystem.model.Programa;
import com.dynamite.pensumsystem.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @PostMapping("/add")
    public String addPrograma(@RequestBody Programa programa){
        programaService.savePrograma(programa);
        return "Nuevo Programa agregado satisfactoriamente.";
    }

    @GetMapping("/get")
    public List<Programa> getAllProgramas(){
        return programaService.getAllProgramas();
    }

    @GetMapping("/get/{id}")
    public Programa readById(@PathVariable int id) {return programaService.getProgramaById(id);}
    
    @GetMapping("/get/codigo/{codigo}")
    public Programa readByCodigo(@PathVariable String codigo) {return programaService.getProgramaByCode(codigo);}

    @PutMapping("/update/{codigo}")
    public String update(@PathVariable String codigo, @RequestBody Programa programa) {
        //Buscamos el ID por medio del odigo de programa
        programa.setId(programaService.getProgramaByCode(codigo).getId());

        //Pasamos el objeto con los nuevos datos
        return programaService.updatePrograma(programa);
    }
    
    @PutMapping("/update/id/{id}")
    public String updateById(@PathVariable int id, @RequestBody Programa programa) {
        //Buscamos el ID por medio del odigo de programa
        programa.setId(id);

        //Pasamos el objeto con los nuevos datos
        return programaService.updatePrograma(programa);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return programaService.deletePrograma(id);
    }
}
