package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Usuario;

import com.dynamite.pensumsystem.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario){
        if(usuario != null)
        return usuarioRepository.save(usuario);
        return new Usuario();
    }

    @Override
    public List<Usuario> getAllUsuarios() { return usuarioRepository.findAll();}

    @Override
    public Usuario getUsuarioById(int id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    @Override
    public Usuario getUsuarioByCorreo(String correo){
        return usuarioRepository.findUsuarioByCorreo(correo);
    }

    @Override
    public Usuario getUsuarioByUsername(String username){
        return usuarioRepository.findUsuarioByUsername(username);
    }
    
    @Override
    public Usuario getUsuarioByUsernameAndPassword(String username, String password) {
    	return usuarioRepository.findUsuarioByUsernameAndPassword(username, password);
    }

    @Override
    public String updateUsuario(Usuario usuario){
        Optional<Usuario> encontrarUsuario = usuarioRepository.findById(usuario.getId());
        if (encontrarUsuario.isPresent()) {
            Usuario usuarioActualizado = encontrarUsuario.get();
            usuarioActualizado.setPrograma(usuario.getPrograma());
            usuarioActualizado.setUsername(usuario.getUsername());
            usuarioActualizado.setPassword(usuario.getPassword());
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setApellido(usuario.getApellido());
            usuarioActualizado.setCorreo(usuario.getCorreo());
            usuarioActualizado.setRol(usuario.getRol());
            usuarioActualizado.setStatus(usuario.getStatus());
            usuarioRepository.save(usuarioActualizado);
            return "¡Usuario actualizado con exito! (User ID: " + usuario.getId()+").";
        }
        return "Error: Usuario no actualizado.";
    }

    @Override
    public String deleteUsuario(int id){
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteById(id);
            return "Usuario ID: " + id +" ha sido eliminado.";
        }
        return "Error: Usuario no encontrado.";
    }
    
}
