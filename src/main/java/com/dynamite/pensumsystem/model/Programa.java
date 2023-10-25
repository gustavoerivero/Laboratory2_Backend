package com.dynamite.pensumsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty
    @Column(name = "codigo", length = 10, unique = true, nullable = false)
    private String codigo;

    @JsonProperty
    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;

    @JsonProperty
    @Column(name = "status", length = 1, nullable = false)
    private char status = 'A';

    public Programa() {
    }
    
    public Programa (int id, String codigo, String nombre, char status) {
    	this.id = id;
    	this.codigo = codigo;
    	this.nombre = nombre;
    	this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}