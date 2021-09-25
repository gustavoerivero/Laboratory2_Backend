package com.dynamite.pensumsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pensum")
public class Pensum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int pensumId;

    @JsonProperty
    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @JsonProperty
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JsonProperty
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @JsonProperty
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "codPrograma")
    private Programa codPrograma;

    @JsonProperty
    @Column(name = "status", nullable = false)
    private char status = 'A';

    public Pensum() {
    }

    public int getPensumId() {
        return pensumId;
    }

    public void setPensumId(int pensumId) {
        this.pensumId = pensumId;
    }

    public Programa getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(Programa codPrograma) {
        this.codPrograma = codPrograma;
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
