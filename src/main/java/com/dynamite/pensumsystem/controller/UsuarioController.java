package com.dynamite.pensumsystem.controller;

import com.dynamite.pensumsystem.model.Usuario;
import com.dynamite.pensumsystem.service.UsuarioService;
import com.dynamite.pensumsystem.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ProgramaService programaService;
    
    @PostMapping("/add")
    public String addAdmin(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
        return "Nuevo Administrador agregado satisfactoriamente.";
    }

    @PostMapping("/add/{codigoPrograma}")
    public String addUsuario(@PathVariable String codigoPrograma, @RequestBody Usuario usuario){
    	usuario.setPrograma(programaService.getProgramaByCode(codigoPrograma));
        usuarioService.saveUsuario(usuario);
        return "Nuevo Usuario agregado satisfactoriamente.";
    }

    @GetMapping("/get")
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/get/{id}")
    public Usuario readById(@PathVariable int id) {return usuarioService.getUsuarioById(id);}

    @GetMapping("/get/correo/{correo}")
    public Usuario readByCorreo(@PathVariable String correo) {
        return usuarioService.getUsuarioByCorreo(correo);
    }
    
    @GetMapping("/get/username/{username}")
    public Usuario readByUsername(@PathVariable String username) {return usuarioService.getUsuarioByUsername(username);}
    
    @GetMapping("/login/{username}/{password}")
    public Usuario login(@PathVariable String username, @PathVariable String password) {return usuarioService.getUsuarioByUsernameAndPassword(username, password);}

    @PutMapping("/update/{username}/{codigoPrograma}")
    public String update(@PathVariable String username, @PathVariable String codigoPrograma, @RequestBody Usuario usuario) {
        //Buscamos el ID por medio del Username
        usuario.setId(usuarioService.getUsuarioByUsername(username).getId());
        usuario.setPrograma(programaService.getProgramaByCode(codigoPrograma));

        //Pasamos el objeto con los nuevos datos
        return usuarioService.updateUsuario(usuario);
    }

    @PutMapping("/update/{username}")
    public String updateAdmin(@PathVariable String username, @RequestBody Usuario usuario) {
        //Buscamos el ID por medio del Username
        usuario.setId(usuarioService.getUsuarioByUsername(username).getId());

        //Pasamos el objeto con los nuevos datos
        return usuarioService.updateUsuario(usuario);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return usuarioService.deleteUsuario(id);
    }

}
