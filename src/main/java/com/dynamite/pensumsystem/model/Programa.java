package com.dynamite.pensumsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int programaId;

    @JsonProperty
    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @JsonProperty
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JsonProperty
    @Column(name = "status", nullable = false)
    private char status = 'A';

    public Programa() {
    }

    public int getProgramaId() {
        return programaId;
    }

    public void setProgramaId(int programaId) {
        this.programaId = programaId;
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