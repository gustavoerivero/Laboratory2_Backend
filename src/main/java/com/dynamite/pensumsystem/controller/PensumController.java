package com.dynamite.pensumsystem.controller;

import com.dynamite.pensumsystem.model.Pensum;
import com.dynamite.pensumsystem.service.PensumService;
import com.dynamite.pensumsystem.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pensum")
public class PensumController{

    @Autowired
    private PensumService pensumService;
    @Autowired
    private ProgramaService programaService;

    private static final String baseDir = setDirectorio();

    static String setDirectorio(){
        String baseDir = "";
        Path currentRelativePath = Paths.get("");
        baseDir = currentRelativePath.toAbsolutePath().toString();
        String so = System.getProperty("os.name").toLowerCase();
        if(so.contains("win"))
            return baseDir+"\\src\\main\\resources\\pensum\\";
        else
            return baseDir+"/src/main/resources/pensum/";
    }

    @PostMapping("/add/{codigo}")
    public String addPensum(@PathVariable String codigo, @RequestBody Pensum pensum/*, @RequestBody MultipartFile archivo*/){
        pensum.setCodPrograma(programaService.getProgramaByCode(codigo));
        LocalDate fc = LocalDate.now();
        pensum.setFecha(fc);
        pensumService.savePensum(pensum);

/*      Guardar archivo en carpeta

        Path path = Paths.get(baseDir + pensum.getPensumId());
        try {
            Files.copy(archivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        return "Nuevo Pensum agregado satisfactoriamente.";
    }

    @GetMapping("/getAllPensum")
    public List<Pensum> getAllPensum(){ return pensumService.getAllPensum(); }

    @GetMapping("/get/{id}")
    public Pensum getPensumById(@PathVariable int id) {return pensumService.getPensumById(id);}

    @PutMapping("/update/{codigo}")
    public String update(@PathVariable String codigo, @RequestBody Pensum pensum/*, @RequestBody MultipartFile archivo*/) {
        //Buscamos el ID por medio del codigo
        pensum.setPensumId(pensumService.getPensumByCodigo(codigo).getPensumId());
/*
        if(archivo.isEmpty()) {}
        else {
            Path path = Paths.get(baseDir + pensum.getPensumId());
            try {
                Files.copy(archivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
*/
        //Pasamos el objeto con los nuevos datos
        return pensumService.updatePensum(pensum);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return pensumService.deletePensum(id);
    }

}
