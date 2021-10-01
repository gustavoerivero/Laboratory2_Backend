package com.dynamite.pensumsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @JsonProperty
    @Column(name = "codigo", unique = true, nullable = false, length = 10)
    private String codigo;

    @JsonProperty
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @JsonProperty
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @JsonProperty
    @Column(name = "status", nullable = false, length = 1)
    private char status = 'A';

    public Departamento() {
    }

    public Departamento(int id, String codigo, String nombre, String descripcion, char status) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
