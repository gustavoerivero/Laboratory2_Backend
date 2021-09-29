package com.dynamite.pensumsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "cod_programa", nullable = true)
    private Programa programa;

    @JsonProperty
    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @JsonProperty
    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @JsonProperty
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @JsonProperty
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    @JsonProperty
    @Column(name = "correo", length = 255, unique = true, nullable = false)
    private String correo;

    @JsonProperty
    @Column(name = "rol", length = 1, nullable = false)
    private char rol;

    @JsonProperty
    @Column(name = "status", length = 1, nullable = false)
    private char status = 'A';

    public Usuario() {
    }
    
    public Usuario (int id, Programa programa, String username, String pass, String nombre, String apellido, String correo, char rol, char status) {
    	this.id = id;
    	this.programa = programa;
    	this.username = username;
    	this.password = pass;
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.correo = correo;
    	this.rol = rol;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public char getRol() {
		return rol;
	}

	public void setRol(char rol) {
		this.rol = rol;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
       
}
