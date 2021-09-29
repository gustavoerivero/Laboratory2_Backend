package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.Usuario;

import java.util.List;

public interface UsuarioService {
    public Usuario saveUsuario(Usuario usuario);
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuarioById(int id);
    public Usuario getUsuarioByUsername(String username);
    public Usuario getUsuarioByUsernameAndPassword(String username, String password);
    public Usuario getUsuarioByCorreo(String correo);
    public String updateUsuario(Usuario usuario);
    public String deleteUsuario(int id);
}
