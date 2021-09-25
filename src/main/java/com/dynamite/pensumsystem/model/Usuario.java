package com.dynamite.pensumsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    @Column(name = "id")
    private int usuarioId;

    @JsonProperty
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @JsonProperty
    @Column(name = "password", nullable = false)
    private String password;

    @JsonProperty
    @Column(name = "name", nullable = false)
    private String name;

    @JsonProperty
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @JsonProperty
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonProperty
    @Column(name = "rol", nullable = false)
    private String rol;

    @JsonProperty
    @Column(name = "status", nullable = false)
    private char status = 'A';

    public Usuario() {
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
