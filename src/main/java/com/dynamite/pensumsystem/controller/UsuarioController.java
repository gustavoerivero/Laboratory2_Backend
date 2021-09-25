package com.dynamite.pensumsystem.controller;

import com.dynamite.pensumsystem.model.Usuario;
import com.dynamite.pensumsystem.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    public String addUsuario(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
        return "Nuevo Usuario agregado satisfactoriamente.";
    }

    @GetMapping("/get")
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/get/{id}")
    public Usuario readById(@PathVariable int id) {return usuarioService.getUsuarioById(id);}

    @GetMapping("/get/{mail}")
    public Usuario readByEmail(@PathVariable String mail) {
        return usuarioService.getUsuarioByEmail(mail);
    }

    @PutMapping("/update/{username}")
    public String update(@PathVariable String username, @RequestBody Usuario usuario) {
        //Buscamos el ID por medio del Username
        usuario.setUsuarioId(usuarioService.getUsuarioByUsername(username).getUsuarioId());

        //Pasamos el objeto con los nuevos datos
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return usuarioService.deleteUsuario(id);
    }

}
