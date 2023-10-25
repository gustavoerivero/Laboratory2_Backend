package com.dynamite.pensumsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pensum")
public class Pensum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cod_programa", nullable = false)
    private Programa programa;

    @ManyToOne
    @JoinColumn(name = "cod_departamento", nullable = false)
    private Departamento departamento;

    @JsonProperty
    @Column(name = "codigo", unique = true, nullable = false, length = 10)
    private String codigo;

    @JsonProperty
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @JsonProperty
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha = LocalDate.now();

    @JsonProperty
    @Column(name = "status", nullable = false, length = 1)
    private char status = 'A';

    public Pensum() {
    }
    
    public Pensum(int id, String codigo, String descripcion, LocalDate fecha, Programa programa, Departamento departamento, char status) {
    	this.id = id;
    	this.programa = programa;
        this.departamento = departamento;
    	this.codigo = codigo;
    	this.descripcion = descripcion;
    	this.fecha = fecha;
    	this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
