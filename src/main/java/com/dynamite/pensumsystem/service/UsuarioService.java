package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Usuario;

import java.util.List;

public interface UsuarioService {
    public Usuario saveUsuario(Usuario usuario);
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuarioById(int id);
    public Usuario getUsuarioByUsername(String username);
    public Usuario getUsuarioByEmail(String email);
    public String updateUsuario(Usuario usuario);
    public String deleteUsuario(int id);
    public List<Usuario> getUsuariosByRol(String Rol);

}
