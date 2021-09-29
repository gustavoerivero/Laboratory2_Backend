package com.dynamite.pensumsystem.repository;

import com.dynamite.pensumsystem.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findUsuarioByCorreo(String correo);
    public Usuario findUsuarioByUsername(String username);
    public Usuario findUsuarioByUsernameAndPassword(String username, String password);
}
