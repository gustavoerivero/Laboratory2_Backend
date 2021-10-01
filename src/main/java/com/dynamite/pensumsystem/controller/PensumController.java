package com.dynamite.pensumsystem.controller;

import com.dynamite.pensumsystem.model.Pensum;
import com.dynamite.pensumsystem.service.DepartamentoService;
import com.dynamite.pensumsystem.service.PensumService;
import com.dynamite.pensumsystem.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/pensum")
public class PensumController{

    @Autowired
    private PensumService pensumService;
    @Autowired
    private ProgramaService programaService;
    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping("/add/{codigoPrograma}/{codigoDepartamento}")
    public String addPensum(@PathVariable String codigoPrograma, @PathVariable String codigoDepartamento, @RequestBody Pensum pensum){
        pensum.setPrograma(programaService.getProgramaByCode(codigoPrograma));
        pensum.setDepartamento(departamentoService.getDepartamentoByCodigo(codigoDepartamento));
        pensumService.savePensum(pensum);
        
        return "Nuevo Pensum agregado satisfactoriamente.";
    }

    @GetMapping("/get")
    public List<Pensum> getAllPensum(){ return pensumService.getAllPensum(); }

    @GetMapping("/get/{id}")
    public Pensum getPensumById(@PathVariable int id) {return pensumService.getPensumById(id);}
    
    @GetMapping("/get/codigo/{codigo}")
    public Pensum getPensumByCodigo(@PathVariable String codigo) {return pensumService.getPensumByCodigo(codigo);}

    @GetMapping("/get/programa/{codigoPrograma}")
    public List<Pensum> getAllPensumByPrograma(@PathVariable String codigoPrograma) {return pensumService.getAllPensumByPrograma(codigoPrograma);}

    @GetMapping("/get/programa/departamento/{codigoDepartamento}")
    public List<Pensum> getAllPensumByDepartamento(@PathVariable String codigoDepartamento) {return pensumService.getAllPensumByDepartamento(codigoDepartamento);}

    @PutMapping("/update/{codigoPensum}/{codigoPrograma}/{codigoDepartamento")
    public String update(@PathVariable String codigoPensum, @PathVariable String codigoPrograma, @PathVariable String codigoDepartamento, @RequestBody Pensum pensum) {
        //Buscamos el ID por medio del codigo
        pensum.setId(pensumService.getPensumByCodigo(codigoPensum).getId());
        pensum.setPrograma(programaService.getProgramaByCode(codigoPrograma));
        pensum.setDepartamento(departamentoService.getDepartamentoByCodigo(codigoDepartamento));      
        //Pasamos el objeto con los nuevos datos
        return pensumService.updatePensum(pensum);
    }
    
    @PutMapping("/update/id/{id}/{codigoPrograma}/{codigoDepartamento}")
    public String updateById(@PathVariable int id, @PathVariable String codigoPrograma, @PathVariable String codigoDepartamento, @RequestBody Pensum pensum) {
        //Buscamos el ID por medio del codigo
        pensum.setId(id);
        pensum.setPrograma(programaService.getProgramaByCode(codigoPrograma));
        pensum.setDepartamento(departamentoService.getDepartamentoByCodigo(codigoDepartamento));      
        
        //Pasamos el objeto con los nuevos datos
        return pensumService.updatePensum(pensum);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return pensumService.deletePensum(id);
    }

}
